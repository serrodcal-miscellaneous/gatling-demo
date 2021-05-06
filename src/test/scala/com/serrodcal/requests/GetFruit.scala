package com.serrodcal.requests

// Use ...Predef._ to get the implicit
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetFruit {

  val request = exec( session => session.set("id", session("fruitId").as[String]))
    .exec(http("getFruits")
    .get("/fruits/${id}")
    .check(status.is(200))
    .check(jsonPath("$.id").exists)
    .check(jsonPath("$.name").exists)
  )

}
