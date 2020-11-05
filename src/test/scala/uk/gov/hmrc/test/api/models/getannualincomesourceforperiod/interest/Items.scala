package uk.gov.hmrc.test.api.models.getannualincomesourceforperiod.interest

import play.api.libs.json._
import uk.gov.hmrc.test.api.models.getannualincomesourceforperiod.Monetary

case class Items(incomeSourceId: String, taxedUkInterest: Option[Monetary], untaxedUkInterest: Option[Monetary])

object Items{

  implicit val reads: Reads[Items] = new Reads[Items] {
    def reads(json: JsValue): JsResult[Items] = {
      for {
        incomeSourceId <- (json \ "incomeSourceId").validate[String]
        taxedUkInterest <- (json \ "taxedUkInterest").validateOpt[Monetary]
        untaxedUkInterest <- (json \ "untaxedUkInterest").validateOpt[Monetary]
      } yield Items(incomeSourceId, taxedUkInterest, untaxedUkInterest)
    }
  }
}


