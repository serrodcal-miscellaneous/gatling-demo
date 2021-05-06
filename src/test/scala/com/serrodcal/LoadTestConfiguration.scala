package com.serrodcal

import com.typesafe.config.ConfigFactory

object LoadTestConfiguration {

  val conf = ConfigFactory.load()
  val baseUrl = conf.getString("baseUrl")

}
