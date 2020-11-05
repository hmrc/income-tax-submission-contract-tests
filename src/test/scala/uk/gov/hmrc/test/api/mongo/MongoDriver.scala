package uk.gov.hmrc.test.api.mongo

import org.mongodb.scala._
import uk.gov.hmrc.test.api.mongo.MongoHelper._

object MongoDriver {

  // Connect to the default server localhost on port 27017
  // Dropping Mongo like this will only work locally, unless you have config for other MongoClients.
  // Arguably easier to hit a test-only endpoint in all environments, so no config needed.
  private val mongoClient: MongoClient = MongoClient()
  private val itsaStub: MongoDatabase = mongoClient.getDatabase("income-tax-submission-stub")

  def dropDatabases(): Unit = {
    itsaStub.drop().printResults()
  }

}
