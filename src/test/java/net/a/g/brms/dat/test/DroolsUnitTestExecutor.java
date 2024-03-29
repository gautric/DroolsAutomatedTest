package net.a.g.brms.dat.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.PropertyUtils;
import org.drools.core.command.runtime.rule.AgendaGroupSetFocusCommand;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.drools.core.command.runtime.rule.QueryCommand;
import org.drools.core.runtime.rule.impl.FlatQueryResults;
import org.junit.jupiter.api.function.Executable;
import org.kie.api.KieBase;
import org.kie.api.command.Command;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

import com.codahale.metrics.Timer;
import com.codahale.metrics.Timer.Context;

import net.a.g.brms.dat.model.Result;
import net.a.g.brms.dat.test.excel.ItemUnitTestRow;
import net.a.g.brms.dat.util.Constantes;
import net.a.g.brms.dat.util.PerfRuleListener;
import net.a.g.brms.dat.util.RuleListener;

@Named("testUnitExecutor")
@Dependent
public class DroolsUnitTestExecutor implements Executable {

	@Inject
	private StatelessKieSession kieSession;

	@Inject
	private KieBase kieBase;

	private ItemUnitTestRow unitTest;

	@Override
	public void execute() throws Throwable {

		FactType characterFactType = kieBase.getFactType(Constantes.NET_A_G_BRMS_DAT_MODEL, Constantes.PLAYER);

		Object player = characterFactType.newInstance();

		kieSession.addEventListener(RuleListener.getInstance());

		kieSession.addEventListener(PerfRuleListener.getInstance());

		PropertyUtils.copyProperties(player, unitTest);

		@SuppressWarnings("rawtypes")
		List<Command> cmds = new ArrayList<Command>();

		cmds.add(new InsertObjectCommand(player));
		cmds.add(new AgendaGroupSetFocusCommand(Constantes.RULEFLOW_GROUP));

		cmds.add(new FireAllRulesCommand(Constantes.FIRED));
		cmds.add(new QueryCommand(Constantes.RESULTS, Constantes.GET_RESULT));

		Context context = PerfRuleListener.metricRegistry.timer("fireallrule").time();

		ExecutionResults response = kieSession.execute(CommandFactory.newBatchExecution(cmds));

		context.stop();

		assertEquals(unitTest.getFired(), (int) response.getValue(Constantes.FIRED));

		if ((int) response.getValue(Constantes.FIRED) == 1) {

			FlatQueryResults queryResult = (FlatQueryResults) response.getValue(Constantes.RESULTS);

			Result er = (Result) queryResult.iterator().next().get(Constantes.RESULT);

			assertNotNull(er);

			assertEquals(unitTest.isResult(), er.isOk());
			if (unitTest.isResult()) {
				assertEquals(unitTest.isAdult(), er.isAdult());
			} else {
				assertEquals(unitTest.getMessage(), er.getMessage());
			}
		}
	}

	public DroolsUnitTestExecutor addUnitTest(ItemUnitTestRow unitTest) {
		this.unitTest = unitTest;
		return this;
	}

}
