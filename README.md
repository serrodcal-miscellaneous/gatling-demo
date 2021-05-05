gatling-demo
=========================

Simple showcase of a maven project using the gatling-maven-plugin.

Before testing, you will need to run the following docker compose:

    $docker compose up

To test it out, simply execute the following command:

    $mvn gatling:test -Dgatling.simulationClass=computerdatabase.BasicSimulation

or simply:

    $mvn gatling:test
