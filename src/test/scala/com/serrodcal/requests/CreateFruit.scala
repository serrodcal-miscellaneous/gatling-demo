package com.serrodcal.requests

// Use ...Predef._ to get the implicit
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object CreateFruit {

  val feeder = csv("feeders/fruits.csv").circular

  val headers = Map(
    "Content-Type" -> "application/json",
  )

  val request = feed(feeder)
    .exec(http("createFruit")
      .post("/fruits/")
      .headers(headers)
      .body(ElFileBody("bodies/createFruit.json")).asJson
      .check(status.is(201))
      //.check(header("SOME-HEADER").saveAs("whatever"))
      .check(jsonPath("$.id").exists.saveAs("fruitId"))
    )

}
