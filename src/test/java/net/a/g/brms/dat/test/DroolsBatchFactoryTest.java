package net.a.g.brms.dat.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldJunit5Extension;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.CsvReporter;
import com.creditdatamw.zerocell.Reader;

import net.a.g.brms.dat.test.excel.ItemUnitTestRow;
import net.a.g.brms.dat.test.util.DroolsBatchFactoryProperties;
import net.a.g.brms.dat.util.PerfRuleListener;

@ExtendWith(WeldJunit5Extension.class)
public class DroolsBatchFactoryTest {

	private static Logger LOGGER = LoggerFactory.getLogger(DroolsBatchFactoryTest.class);

	@WeldSetup
	public WeldInitiator weld = WeldInitiator.performDefaultDiscovery();

	@Inject
	public Instance<DroolsUnitTestExecutor> exec;

	@TestFactory
	@DisplayName("Execution des tests Excel")
	public Stream<DynamicNode> excelExtratorforUnit() throws Exception {

		File excelFile = new File(
				DroolsBatchFactoryProperties.getString(DroolsBatchFactoryProperties.CHARACTER_UNIT_TEST_FILE_NAME));
		String sheetName = DroolsBatchFactoryProperties
				.getString(DroolsBatchFactoryProperties.CHARACTER_UNIT_TEST_SHEET);

		return Reader.of(ItemUnitTestRow.class).from(excelFile).sheet(sheetName).list().stream()
				.map(this::mapItemUnitTestRowtoDynamicTest);
	}

	public DynamicNode mapItemUnitTestRowtoDynamicTest(Object unit) {

		DroolsUnitTestExecutor execTest = exec.get().addUnitTest((ItemUnitTestRow) unit);

		String testName = " [" //$NON-NLS-1$
				+ ((ItemUnitTestRow) unit).getRowNumber() + "] = " //$NON-NLS-1$
				+ unit;
		return DynamicTest.dynamicTest(testName, execTest);
	}

	@AfterAll
	public static void after() {

		LOGGER.info("End of Test");

		ConsoleReporter reporter = ConsoleReporter.forRegistry(PerfRuleListener.metricRegistry)
				.convertDurationsTo(TimeUnit.MICROSECONDS).build();

		reporter.report();
	}
}
