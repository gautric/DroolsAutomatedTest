# Drools Automated Test

But : Automatiser les tests en utilisant des Excel comme fiche de test

Goal : Automate test using Excel document to validate in this case Drools Engine.

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

## Mode Eclipse

Lancer le test Junit _net.a.g.brms.dat.test.TestDroolsBatchFactory_

![Image execution dans Eclipse](img/eclipse.png?raw=true)
