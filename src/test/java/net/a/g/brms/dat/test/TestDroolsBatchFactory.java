package net.a.g.brms.dat.test;

import java.io.File;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.creditdatamw.zerocell.Reader;

public class TestDroolsBatchFactory {

	private static Logger logger = LoggerFactory.getLogger(TestDroolsBatchFactory.class);

	@BeforeEach
	public void setUp() {
	}

	@TestFactory
	public Stream<DynamicTest> excelExtratorforUnit() throws Exception {

		KieServices kieServices = KieServices.Factory.get();
		KieContainer kContainer = kieServices.getKieClasspathContainer();
		StatelessKieSession kieSession = kContainer.getKieBase().newStatelessKieSession();

		File excelFile = new File(TestDroolsBatchFactoryProperties
				.getString(TestDroolsBatchFactoryProperties.CHARACTER_UNIT_TEST_FILE_NAME));
		String sheetName = TestDroolsBatchFactoryProperties
				.getString(TestDroolsBatchFactoryProperties.CHARACTER_UNIT_TEST_SHEET);

		return Reader.of(ItemUnitTestRow.class).from(excelFile).sheet(sheetName).list().stream()
				.map(unit -> mapItemUnitTestRowtoDynamicTest((ItemUnitTestRow) unit, kieSession));
	}

	public static DynamicTest mapItemUnitTestRowtoDynamicTest(ItemUnitTestRow unit, StatelessKieSession kieSession) {
		String testName = ItemUnitTestRow.class.getName() + " [" + unit.getRowNumber() + "] = " + unit; //$NON-NLS-1$ //$NON-NLS-2$
		return DynamicTest.dynamicTest(testName,
				ItemUnitTestExecutor.builder().addKieSession(kieSession).addUnitTest(unit));
	}

}
