package net.a.g.brms.dat.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditdatamw.zerocell.Reader;

@RunWith(JUnitPlatform.class)
public class TestDroolsBatchFactory {

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

			String testName = ItemUnitTestRow.class.getName() + " [" + unit.getRowNumber() + "] = " + unit; //$NON-NLS-1$ //$NON-NLS-2$
			DynamicTest dTest = DynamicTest.dynamicTest(testName,
					ItemUnitTestExecutor.builder().addKieSession(kieSession).addUnitTest(unit));

			ret.add(dTest);
		}
		logger.debug("Return " + ret.size() + " Test(s) unit"); //$NON-NLS-1$ //$NON-NLS-2$
		return ret;
	}

}
