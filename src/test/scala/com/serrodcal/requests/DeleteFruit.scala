package com.serrodcal.requests

// Use ...Predef._ to get the implicit
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object DeleteFruit {

  val request = exec( session => session.set("id", session("fruitId").as[String])) // Second way of getting parameters from a previous response using the session
    .exec(http("deleteFruit")
    .delete("/fruits/${id}")
    .check(status.is(204))
  )

}
