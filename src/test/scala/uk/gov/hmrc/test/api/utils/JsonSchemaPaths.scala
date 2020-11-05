package uk.gov.hmrc.test.api.utils

import java.io.File

object JsonSchemaPaths {

  val schemaPath = "src/test/resources/jsonschema"

  val getAnnualIncomeSourceForPeriod: File = new File(s"$schemaPath/GetAnnualIncomeSourceForPeriod.json")
  val postCreateOrUpdateAnnualIncomeSource: File = new File(s"$schemaPath/CreateOrUpdateAnnualIncomeSource.json")

}
