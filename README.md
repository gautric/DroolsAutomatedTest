# Drools Automated Test

Goal : Automate Drools Engine testing using Excel document for a business validation.

[![Build Status](https://travis-ci.org/gautric/DroolsAutomatedTest.svg?branch=master)](https://travis-ci.org/gautric/DroolsAutomatedTest)

## Requirements

* JDK 11+
* Maven 3.6.0+

## Dependencies

* JUnit 5.4.0
* Drools 7.17.0.Final
* Zerocell 0.3.2

## Test Case

Excel document can be found into _src/test/resources_ folder

![Image du fichier Excel](img/excel.png?raw=true)

## JUnit 5

JUnit 5 can manage dynamic test case. It uses Factory pattern to load a set of test cases from Excel file.
We could also use some other providers like a CSV file or Database.
To parse Excel file we gonna use [Zerocell](https://github.com/creditdatamw/zerocell) library providing a very simple and flexible Excel reader.

 _DroolsBatchFactoryTest_  class is the principal class (the factory). It reads Excel file, loads it into a list of _ItemUnitTestRow_ and create a list of test case excutor _DroolsUnitTestExecutor_. Class _DroolsUnitTestExecutor_ provides the main function to validate a test, will use _ItemUnitTestRow_ to create some input parameters, execute Drools engine and reuse _ItemUnitTestRow_ for testing the result. This class should manage the whole test flow and, must be robust and reliable.

## Maven Mode

```
mvn test
```

```
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running net.a.g.brms.dat.test.DroolsBatchFactoryTest
16:27:57.191 [main] INFO  o.k.a.i.utils.ServiceDiscoveryImpl - Loading kie.conf from  jar:file:/Users/gautric/.m2/repository/org/drools/drools-compiler/7.17.0.Final/drools-compiler-7.17.0.Final.jar!/META-INF/kie.conf in classloader jdk.internal.loader.ClassLoaders$AppClassLoader@799f7e29


....


16:27:57.246 [main] INFO  o.d.c.k.b.impl.ClasspathKieProject - Found kmodule: file:/Users/gautric/Source/git/DroolsAutomatedTest/target/classes/META-INF/kmodule.xml
16:27:57.247 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - KieModule URL type=file url=/Users/gautric/Source/git/DroolsAutomatedTest/target/classes
16:27:57.627 [main] WARN  o.d.c.k.b.impl.ClasspathKieProject - Unable to find pom.properties in /Users/gautric/Source/git/DroolsAutomatedTest/target/classes
16:27:57.635 [main] INFO  o.d.c.k.b.impl.ClasspathKieProject - Recursed up folders, found and used pom.xml /Users/gautric/Source/git/DroolsAutomatedTest/pom.xml
16:27:57.641 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - Discovered classpath module net.a.g.brms:drools-automated-test:1.0.0
16:27:57.644 [main] INFO  o.d.c.k.b.impl.KieRepositoryImpl - KieModule was added: FileKieModule[releaseId=net.a.g.brms:drools-automated-test:1.0.0,file=/Users/gautric/Source/git/DroolsAutomatedTest/target/classes]
16:27:59.871 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now FIRING_ALL_RULES
16:27:59.931 [main] DEBUG org.drools.core.common.DefaultAgenda - State was FIRING_ALL_RULES is now HALTING
16:27:59.931 [main] DEBUG org.drools.core.common.DefaultAgenda - State was HALTING is now INACTIVE
16:27:59.932 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.932 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.932 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.932 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.935 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.938 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.945 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now DISPOSED
16:27:59.957 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now FIRING_ALL_RULES
16:27:59.958 [main] DEBUG org.drools.core.common.DefaultAgenda - State was FIRING_ALL_RULES is now HALTING
16:27:59.958 [main] DEBUG org.drools.core.common.DefaultAgenda - State was HALTING is now INACTIVE
16:27:59.959 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.959 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.959 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.959 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.959 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.963 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.964 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now DISPOSED
16:27:59.967 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now FIRING_ALL_RULES
16:27:59.971 [main] DEBUG org.drools.core.common.DefaultAgenda - State was FIRING_ALL_RULES is now HALTING
16:27:59.971 [main] DEBUG org.drools.core.common.DefaultAgenda - State was HALTING is now INACTIVE
16:27:59.972 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.973 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.974 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.974 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.975 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.976 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.976 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now DISPOSED
16:27:59.979 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now FIRING_ALL_RULES
16:27:59.981 [main] DEBUG org.drools.core.common.DefaultAgenda - State was FIRING_ALL_RULES is now HALTING
16:27:59.981 [main] DEBUG org.drools.core.common.DefaultAgenda - State was HALTING is now INACTIVE
16:27:59.982 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.982 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.982 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.984 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.984 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.985 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.986 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now DISPOSED
16:27:59.987 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now FIRING_ALL_RULES
16:27:59.991 [main] DEBUG org.drools.core.common.DefaultAgenda - State was FIRING_ALL_RULES is now HALTING
16:27:59.991 [main] DEBUG org.drools.core.common.DefaultAgenda - State was HALTING is now INACTIVE
16:27:59.993 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.993 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.994 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.994 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.994 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:27:59.995 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:27:59.995 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now DISPOSED
16:27:59.998 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now FIRING_ALL_RULES
16:28:00.001 [main] DEBUG org.drools.core.common.DefaultAgenda - State was FIRING_ALL_RULES is now HALTING
16:28:00.002 [main] DEBUG org.drools.core.common.DefaultAgenda - State was HALTING is now INACTIVE
16:28:00.003 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:28:00.005 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:28:00.005 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:28:00.005 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:28:00.008 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now EXECUTING_TASK
16:28:00.012 [main] DEBUG org.drools.core.common.DefaultAgenda - State was EXECUTING_TASK is now INACTIVE
16:28:00.017 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now DISPOSED
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.001 s - in net.a.g.brms.dat.test.DroolsBatchFactoryTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]

```

## Eclipse Mode

Via Eclipse Launcher run _net.a.g.brms.dat.test.DroolsBatchFactoryTest_

![Image execution dans Eclipse](img/eclipse.png?raw=true)
