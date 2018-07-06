package net.a.g.brms.dat.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.drools.core.command.runtime.DisposeCommand;
import org.drools.core.command.runtime.SetGlobalCommand;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.drools.core.command.runtime.rule.QueryCommand;
import org.drools.core.runtime.rule.impl.FlatQueryResults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditdatamw.zerocell.Reader;

import net.a.g.brms.dat.model.fact.Character;
import net.a.g.brms.dat.model.fact.Result;

@RunWith(JUnitPlatform.class)
public class TestDroolsBatchFactory {

	private static final String RESULT = "result";
	private static final String RESULTS = "results";

	private static Logger logger = LoggerFactory.getLogger(TestDroolsBatchFactory.class);

	@BeforeEach
	public void setUp() {
	}

	@TestFactory
	public Collection<DynamicTest> excelExtratorforUnit() throws Exception {

		KieServices kieServices = KieServices.Factory.get();
		KieContainer kContainer = kieServices.getKieClasspathContainer();
		StatelessKieSession kieSession = kContainer.getKieBase().newStatelessKieSession();

		List<ItemUnitTestRow> listTest = Reader.of(ItemUnitTestRow.class)
				.from(new File(TestDroolsBatchFactoryProperties
						.getString(TestDroolsBatchFactoryProperties.CHARACTER_UNIT_TEST_FILE_NAME)))
				.sheet(TestDroolsBatchFactoryProperties
						.getString(TestDroolsBatchFactoryProperties.CHARACTER_UNIT_TEST_SHEET))
				.list(); // $NON-NLS-1$ //$NON-NLS-2$

		Collection<DynamicTest> ret = new ArrayList<>();
		for (ItemUnitTestRow unit : listTest) {

			Character c = new Character();

			BeanUtils.copyProperties(c, unit);

			String testName = ItemUnitTestRow.class.getName() + " [" + unit.getRowNumber() + "] = " + unit; //$NON-NLS-1$ //$NON-NLS-2$
			DynamicTest dTest = DynamicTest.dynamicTest(testName, () -> {

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

				assertEquals(unit.isResult(), er.isOk());
				if (unit.isResult()) {
					assertEquals(unit.isAdult(), er.isAdult());
				} else {
					assertEquals(unit.getMessage(), er.getMessage());
				}

			});

			ret.add(dTest);
		}
		logger.debug("Return " + ret.size() + " Test(s) unit"); //$NON-NLS-1$ //$NON-NLS-2$
		return ret;
	}

}
