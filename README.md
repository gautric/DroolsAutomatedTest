# Drools Automated Test

Goal : Automate Drools Engine testing using Excel document for a business validation.

[![Build Status](https://travis-ci.org/gautric/DroolsAutomatedTest.svg?branch=master)](https://travis-ci.org/gautric/DroolsAutomatedTest)

## Requirements

* JDK 11+
* Maven 3.8+

## Dependencies

* JUnit 5.7+
* Drools 8.16+
* Zerocell 0.5.1

## Rule Case

Rules are developed with Excel Drools feature. They can be found into _src/main/resources/net/a/g/brms/dat/rule/excel_ folder.
[Please see Drools documentation how to develop with it.](https://docs.jboss.org/drools/release/latest/drools-docs/html_single/#decision-tables-con_decision-tables)

![Image du fichier Excel](img/rules.png?raw=true)

## Test Case

Excel document can be found into _src/test/resources_ folder

![Image du fichier Excel](img/excel.png?raw=true)

## JUnit 5

JUnit 5 can manage dynamic test case. It uses Factory pattern to load a set of test cases from Excel file.
We could also use some other providers like a CSV file or Database.
To parse Excel file we gonna use [Zerocell](https://github.com/creditdatamw/zerocell) library providing a very simple and flexible Excel reader.

 _DroolsBatchFactoryTest_  class is the principal class (the factory). It reads Excel file, loads it into a list of _ItemUnitTestRow_ and create a list of test case excutor _DroolsUnitTestExecutor_. Class _DroolsUnitTestExecutor_ provides the main function to validate a test, will use _ItemUnitTestRow_ to create some input parameters, execute Drools engine and reuse _ItemUnitTestRow_ for testing the result. This class should manage the whole test flow and, must be robust and reliable.

## Maven Mode

The command to execute test.

```
mvn test
```

The result of the previous command.

```
[INFO] --- maven-surefire-plugin:3.0.0-M4:test (default-test) @ drools-automated-test ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running net.a.g.brms.dat.test.DroolsBatchFactoryTest
23:35:25,069 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.groovy]
23:35:25,069 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback-test.xml]
23:35:25,070 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Found resource [logback.xml] at [file:/Users/gautric/Dropbox/Source/DroolsAutomatedTest/target/test-classes/logback.xml]
23:35:25,213 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - debug attribute not set
23:35:25,229 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - About to instantiate appender of type [ch.qos.logback.core.ConsoleAppender]
23:35:25,236 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - Naming appender as [STDOUT]
23:35:25,388 |-WARN in ch.qos.logback.core.ConsoleAppender[STDOUT] - This appender no longer admits a layout as a sub-component, set an encoder instead.
23:35:25,389 |-WARN in ch.qos.logback.core.ConsoleAppender[STDOUT] - To ensure compatibility, wrapping your layout in LayoutWrappingEncoder.
23:35:25,389 |-WARN in ch.qos.logback.core.ConsoleAppender[STDOUT] - See also http://logback.qos.ch/codes.html#layoutInsteadOfEncoder for details
23:35:25,392 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [org.jbpm] to DEBUG
23:35:25,392 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [org.drools] to DEBUG
23:35:25,392 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [org.drools.core.common] to INFO
23:35:25,392 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [net.a.g] to INFO
23:35:25,393 |-INFO in ch.qos.logback.classic.joran.action.RootLoggerAction - Setting level of ROOT logger to ERROR
23:35:25,393 |-INFO in ch.qos.logback.core.joran.action.AppenderRefAction - Attaching appender named [STDOUT] to Logger[ROOT]
23:35:25,393 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - End of configuration.
23:35:25,394 |-INFO in ch.qos.logback.classic.joran.JoranConfigurator@6d026701 - Registering current configuration as safe fallback point

2020-09-02 23:35:26 [main] INFO  o.d.c.k.b.impl.ClasspathKieProject - Found kmodule: file:/Users/gautric/Dropbox/Source/DroolsAutomatedTest/target/classes/META-INF/kmodule.xml
2020-09-02 23:35:26 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - KieModule URL type=file url=/Users/gautric/Dropbox/Source/DroolsAutomatedTest/target/classes
2020-09-02 23:35:27 [main] WARN  o.d.c.k.b.impl.ClasspathKieProject - Unable to find pom.properties in /Users/gautric/Dropbox/Source/DroolsAutomatedTest/target/classes
2020-09-02 23:35:27 [main] INFO  o.d.c.k.b.impl.ClasspathKieProject - Recursed up folders, found and used pom.xml /Users/gautric/Dropbox/Source/DroolsAutomatedTest/pom.xml
2020-09-02 23:35:27 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - Discovered classpath module net.a.g.brms:drools-automated-test:1.0.0
2020-09-02 23:35:27 [main] DEBUG o.d.c.k.b.impl.KieRepositoryImpl - KieModule was added: org.drools.modelcompiler.CanonicalKieModule@23202c31
2020-09-02 23:35:27 [main] DEBUG org.drools.cdi.KieCDIExtension - Added Bean for @KBase(null)
2020-09-02 23:35:27 [main] DEBUG org.drools.cdi.KieCDIExtension - Added Bean for Stateless @KSession(null) from: org.drools.modelcompiler.CanonicalKieModule@23202c31
2020-09-02 23:35:29 [main] INFO  net.a.g.brms.dat.util.RuleListener - => Rule Fired : 'Rule : HUMAN <  >= 18'
2020-09-02 23:35:29 [main] INFO  net.a.g.brms.dat.util.RuleListener - => Rule Fired : 'Rule : HUMAN <  >= 18'
2020-09-02 23:35:29 [main] INFO  net.a.g.brms.dat.util.RuleListener - => Rule Fired : 'Rule : WOOKIEE <  >= 75'
2020-09-02 23:35:29 [main] INFO  net.a.g.brms.dat.util.RuleListener - => Rule Fired : 'Rule : HUMAN < 18 >='
2020-09-02 23:35:29 [main] INFO  net.a.g.brms.dat.util.RuleListener - => Rule Fired : 'Rule : HUMAN <  >= 18'
2020-09-02 23:35:29 [main] INFO  net.a.g.brms.dat.util.RuleListener - => Rule Fired : 'Rule : UNKNOW <  >='
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.421 s - in net.a.g.brms.dat.test.DroolsBatchFactoryTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0


```

## Eclipse Mode

Via Eclipse Launcher run _net.a.g.brms.dat.test.DroolsBatchFactoryTest_

![Image execution dans Eclipse](img/eclipse.png?raw=true)
