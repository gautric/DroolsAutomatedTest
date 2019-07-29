package net.a.g.brms.dat.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.drools.core.command.runtime.rule.AgendaGroupSetFocusCommand;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.drools.core.command.runtime.rule.QueryCommand;
import org.drools.core.runtime.rule.impl.FlatQueryResults;
import org.junit.jupiter.api.function.Executable;
import org.kie.api.command.Command;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;

import net.a.g.brms.dat.test.excel.ItemUnitTestRow;
import net.a.g.brms.dat.util.Constantes;

public class DroolsUnitTestExecutor implements Executable {

	private StatelessKieSession kieSession;
	private ItemUnitTestRow unitTest;

	public static DroolsUnitTestExecutor builder() {
		return new DroolsUnitTestExecutor();
	}

	@Override
	public void execute() throws Throwable {

		FactType resultFactType = kieSession.getKieBase().getFactType(Constantes.NET_A_G_BRMS_DAT_MODEL,
				Constantes.RESULTTYPE);
		FactType characterFactType = kieSession.getKieBase().getFactType(Constantes.NET_A_G_BRMS_DAT_MODEL,
				Constantes.PLAYER);

		Object player = characterFactType.newInstance();

		characterFactType.set(player, Constantes.NAME, PropertyUtils.getSimpleProperty(unitTest, Constantes.NAME));
		characterFactType.set(player, Constantes.SPECIES,
				PropertyUtils.getSimpleProperty(unitTest, Constantes.SPECIES));
		characterFactType.set(player, Constantes.AGE, PropertyUtils.getSimpleProperty(unitTest, Constantes.AGE));
		characterFactType.set(player, Constantes.GENDER, PropertyUtils.getSimpleProperty(unitTest, Constantes.GENDER));

		@SuppressWarnings("rawtypes")
		List<Command> cmds = new ArrayList<Command>();

		cmds.add(new InsertObjectCommand(player));
		cmds.add(new AgendaGroupSetFocusCommand(Constantes.RULEFLOW_GROUP));

		cmds.add(new FireAllRulesCommand(Constantes.FIRED));
		cmds.add(new QueryCommand(Constantes.RESULTS, Constantes.GET_RESULT));

		ExecutionResults response = kieSession.execute(CommandFactory.newBatchExecution(cmds));

		assertEquals(unitTest.getFired(), (int) response.getValue(Constantes.FIRED));

		if ((int) response.getValue(Constantes.FIRED) == 1) {

			FlatQueryResults queryResult = (FlatQueryResults) response.getValue(Constantes.RESULTS);

			Object er = queryResult.iterator().next().get(Constantes.RESULT);

			assertNotNull(er);

			assertEquals(unitTest.isResult(), resultFactType.get(er, Constantes.OK));
			if (unitTest.isResult()) {
				assertEquals(unitTest.isAdult(), resultFactType.get(er, Constantes.ADULT));
			} else {
				assertEquals(unitTest.getMessage(), resultFactType.get(er, Constantes.MESSAGE));
			}
		}
	}

	public StatelessKieSession getKieSession() {
		return kieSession;
	}

	public void setKieSession(StatelessKieSession kieSession) {
		this.kieSession = kieSession;
	}

	public ItemUnitTestRow getUnitTest() {
		return unitTest;
	}

	public void setUnitTest(ItemUnitTestRow unitTest) {
		this.unitTest = unitTest;
	}

	public DroolsUnitTestExecutor addKieSession(StatelessKieSession kieSession) {
		this.kieSession = kieSession;
		return this;
	}

	public DroolsUnitTestExecutor addUnitTest(ItemUnitTestRow unitTest) {
		this.unitTest = unitTest;
		return this;
	}

}
