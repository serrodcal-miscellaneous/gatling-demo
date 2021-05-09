package com.serrodcal

import com.serrodcal.requests.{CreateFruit, DeleteFruit, GetFruit}
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class FruitSimulation extends Simulation {

  val httpProtocol = http
    .enableHttp2 // Experimental and only with Java9+
    .baseUrl(LoadTestConfiguration.baseUrl)

  val scn = scenario("FruitSimulation")
    .exec(CreateFruit.request, GetFruit.request, DeleteFruit.request)

  setUp(
    //scn.inject(atOnceUsers(1)) Basic example
    scn.inject(constantConcurrentUsers(1).during(2.minutes))
       .throttle(reachRps(30).in(30.seconds),holdFor(1.minute))

    // Note: For this example, because of the application checks if a fruit is already exist, no more than 1 user is allowed.
    // In case you set more than 1 user, you will get errors.

  ).protocols(httpProtocol)

}
