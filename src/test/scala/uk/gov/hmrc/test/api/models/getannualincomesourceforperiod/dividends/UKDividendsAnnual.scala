package uk.gov.hmrc.test.api.models.getannualincomesourceforperiod.dividends

import play.api.libs.json._
import uk.gov.hmrc.test.api.models.getannualincomesourceforperiod.Monetary

case class UKDividendsAnnual(ukDividends: Option[Monetary], otherUkDividends: Option[Monetary])

object UKDividendsAnnual{

  implicit val reads: Reads[UKDividendsAnnual] = new Reads[UKDividendsAnnual] {
    def reads(json: JsValue): JsResult[UKDividendsAnnual] = {
      for {
        ukDividends <- (json \ "ukDividends").validateOpt[Monetary]
        otherUkDividends <- (json \ "otherUkDividends").validateOpt[Monetary]
      } yield UKDividendsAnnual(ukDividends, otherUkDividends)
    }
  }
}
