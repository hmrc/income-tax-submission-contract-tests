package uk.gov.hmrc.test.api.models.postcreateorupdateannualincomesource

import play.api.libs.json.{JsResult, JsValue, Reads}

case class PostCreateOrUpdateAnnualIncomeSourceResponse(transactionReference: String)

object PostCreateOrUpdateAnnualIncomeSourceResponse {

  implicit val reads:Reads[PostCreateOrUpdateAnnualIncomeSourceResponse] = new Reads[PostCreateOrUpdateAnnualIncomeSourceResponse]{
    def reads(json: JsValue): JsResult[PostCreateOrUpdateAnnualIncomeSourceResponse] = {
      for {
        transactionRef <- (json \ "transactionReference").validate[String]
      } yield PostCreateOrUpdateAnnualIncomeSourceResponse(transactionRef)
    }
  }

}
