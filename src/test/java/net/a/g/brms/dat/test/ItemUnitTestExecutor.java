package net.a.g.brms.dat.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.drools.core.command.runtime.SetGlobalCommand;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.drools.core.command.runtime.rule.QueryCommand;
import org.drools.core.runtime.rule.impl.FlatQueryResults;
import org.junit.jupiter.api.function.Executable;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.slf4j.LoggerFactory;

import net.a.g.brms.dat.model.fact.Character;
import net.a.g.brms.dat.model.fact.Result;

public class ItemUnitTestExecutor implements Executable {

	private static final String RESULT = "result";
	private static final String RESULTS = "results";
	private StatelessKieSession kieSession;
	private ItemUnitTestRow unitTest;

	public static ItemUnitTestExecutor builder() {
		return new ItemUnitTestExecutor();
	}

	@Override
	public void execute() throws Throwable {

		Character c = new Character();

		BeanUtils.copyProperties(c, unitTest);

		@SuppressWarnings("rawtypes")
		List<Command> cmds = new ArrayList<Command>();
		cmds.add(new SetGlobalCommand("logger",
				LoggerFactory.getLogger(TestDroolsBatchFactory.class.getPackage().getName() + ".rule")));
		cmds.add(new InsertObjectCommand(c));
		cmds.add(new FireAllRulesCommand("object"));
		cmds.add(new QueryCommand(RESULTS, "getResult"));

		ExecutionResults response = kieSession.execute(CommandFactory.newBatchExecution(cmds));

		FlatQueryResults queryResult = (FlatQueryResults) response.getValue(RESULTS);

		Result er = (Result) queryResult.iterator().next().get(RESULT);

		assertNotNull(er);

		assertEquals(unitTest.isResult(), er.isOk());
		if (unitTest.isResult()) {
			assertEquals(unitTest.isAdult(), er.isAdult());
		} else {
			assertEquals(unitTest.getMessage(), er.getMessage());
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

	public ItemUnitTestExecutor addKieSession(StatelessKieSession kieSession) {
		this.kieSession = kieSession;
		return this;
	}

	public ItemUnitTestExecutor addUnitTest(ItemUnitTestRow unitTest) {
		this.unitTest = unitTest;
		return this;
	}

}
