# Drools Automated Test

But : Automatiser les tests en utilisant des Excel comme fiche de test

Goal : Automate test using Excel document to validate in this case Drools Engine.

[![Build Status](https://travis-ci.org/gautric/DroolsAutomatedTest.svg?branch=master)](https://travis-ci.org/gautric/DroolsAutomatedTest)

## Fiche de test

Le fichier des tests est disponibles dans le repertoire _src/test/resources_

Excel document can be found into _src/test/resources_ folder

![Image du fichier Excel](img/excel.png?raw=true)

## JUnit 5

JUnit 5 permet maintenant de créer dynamiquement des test unitaires à l'execution.
Nous utilisons pour cela un parseur Excel pour construire les tests, le moteur JUnit se chargera de les executer.

La classe gerant tout le mécanisme se trouve dans le package _net.a.g.brms.dat.test_ est se nomme _TestDroolsBatchFactory_

## Mode Maven

```
mvn test
```

```
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ drools-automated-test ---
[INFO] Surefire report directory: ...../drools-automated-test/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running net.a.g.brms.dat.test.TestDroolsBatchFactory
Jul 06, 2018 12:46:22 PM org.junit.vintage.engine.discovery.DefensiveAllDefaultPossibilitiesBuilder$DefensiveAnnotatedBuilder buildRunner
WARNING: Ignoring test class using JUnitPlatform runner: net.a.g.brms.dat.test.TestDroolsBatchFactory
Jul 06, 2018 12:46:22 PM org.junit.vintage.engine.discovery.DefensiveAllDefaultPossibilitiesBuilder$DefensiveAnnotatedBuilder buildRunner
WARNING: Ignoring test class using JUnitPlatform runner: net.a.g.brms.dat.test.TestDroolsBatchFactory
12:46:22.642 [main] INFO  o.k.a.i.utils.ServiceDiscoveryImpl - Loading kie.conf from  

... OMIT ...

12:46:22.674 [main] INFO  o.k.a.i.utils.ServiceDiscoveryImpl - Loading kie.conf from  
12:46:22.675 [main] INFO  o.k.a.i.utils.ServiceDiscoveryImpl - Discovered kie.conf url=jar:file:/Users/gautric/.m2/repository/org/drools/drools-decisiontables/7.7.0.Final/drools-decisiontables-7.7.0.Final.jar!/META-INF/kie.conf
12:46:22.677 [main] INFO  o.k.a.i.utils.ServiceDiscoveryImpl - Adding Service org.drools.decisiontable.DecisionTableProviderImpl

12:46:22.713 [main] INFO  o.d.c.k.b.impl.ClasspathKieProject - Found kmodule: file:...../drools-automated-test/target/classes/META-INF/kmodule.xml
12:46:22.713 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - KieModule URL type=file url=...../drools-automated-test/target/classes
12:46:23.024 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - Found and used pom.properties ...../drools-automated-test/target/classes/META-INF/maven/net.a.g.brms/drools-automated-test/pom.properties
12:46:23.028 [main] DEBUG o.d.c.k.b.impl.ClasspathKieProject - Discovered classpath module net.a.g.brms:drools-automated-test:1.0.0
12:46:23.031 [main] INFO  o.d.c.k.b.impl.KieRepositoryImpl - KieModule was added: FileKieModule[releaseId=net.a.g.brms:drools-automated-test:1.0.0,file=...../drools-automated-test/target/classes]
12:46:24.655 [main] DEBUG n.a.g.b.d.t.TestDroolsBatchFactory - Return 6 Test(s) unit
12:46:24.744 [main] DEBUG org.drools.core.common.DefaultAgenda - State was INACTIVE is now FIRING_ALL_RULES
12:46:24.788 [main] INFO  net.a.g.brms.dat.test.rule - call Character Human Adult [Character : name:Han Solo,species:HUMAN,age:64,gender:MALE]
12:46:24.818 [main] INFO  net.a.g.brms.dat.test.rule - call Character Human Adult [Character : name:Rey,species:HUMAN,age:19,gender:FEMALE]
12:46:24.832 [main] INFO  net.a.g.brms.dat.test.rule - call Character Wookie [Character : name:Chewbacca,species:WOOKIEE,age:200,gender:MALE]
12:46:24.844 [main] INFO  net.a.g.brms.dat.test.rule - call Character Human Young [Character : name:Young Anakin,species:HUMAN,age:10,gender:MALE]
12:46:24.848 [main] INFO  net.a.g.brms.dat.test.rule - call Character Human Adult [Character : name:Princess Leia,species:HUMAN,age:19,gender:FEMALE]
12:46:24.855 [main] INFO  net.a.g.brms.dat.test.rule - call Character Unkown [Character : name:YODA,species:UNKNOW,age:900,gender:MALE]

Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 2.893 sec

Results :

Tests run: 7, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 5.506 s
[INFO] Finished at: 2018-07-06T12:46:24+02:00
[INFO] ------------------------------------------------------------------------
```

## Mode Eclipse

Lancer le test Junit _net.a.g.brms.dat.test.TestDroolsBatchFactory_

![Image execution dans Eclipse](img/eclipse.png?raw=true)
