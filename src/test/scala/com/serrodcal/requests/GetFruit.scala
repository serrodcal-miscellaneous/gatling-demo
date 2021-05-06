package com.serrodcal.requests

// Use ...Predef._ to get the implicit
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object GetFruit {

  val request = exec(http("getFruits")
    .get(session => "/fruits/" + session("fruitId").as[String]) // First way of getting parameters from a previous response using the session
    .check(status.is(200))
    .check(jsonPath("$.id").exists)
    .check(jsonPath("$.name").exists)
  )

}
