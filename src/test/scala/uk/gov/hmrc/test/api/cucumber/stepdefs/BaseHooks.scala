package uk.gov.hmrc.test.api.cucumber.stepdefs

import io.cucumber.scala.ScalaDsl
import uk.gov.hmrc.test.api.conf.TestConfiguration
import uk.gov.hmrc.test.api.mongo.MongoDriver
import uk.gov.hmrc.test.api.utils.ApiLogger.log
import uk.gov.hmrc.test.api.utils.ScenarioContext

class BaseHooks extends ScalaDsl {

  Before {
    log.info("Test Set Up")
    ScenarioContext.reset()

    if (TestConfiguration.env == "local") {
      MongoDriver.dropDatabases()
      log.info("income-tax-submission-frontend dropped")
    }
  }

  After {
    log.info("Test Teardown")
    ScenarioContext.reset()

    if (TestConfiguration.env == "local") {
      MongoDriver.dropDatabases()
      log.info("income-tax-submission-frontend dropped")
    }
  }

}