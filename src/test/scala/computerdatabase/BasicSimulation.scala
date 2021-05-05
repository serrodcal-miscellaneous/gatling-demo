package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080")

  val scn = scenario("BasicSimulation")
    .exec(http("getFruits")
      .get("/fruits/"))
    .pause(2)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpProtocol)

}
