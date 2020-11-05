package uk.gov.hmrc.test.api.models.getannualincomesourceforperiod

import play.api.libs.json.{JsResult, JsValue, Reads}
import uk.gov.hmrc.test.api.models.getannualincomesourceforperiod.interest.UKInterestAnnual
import uk.gov.hmrc.test.api.models.getannualincomesourceforperiod.charitablegiving.UKCharitableGivingAnnual
import uk.gov.hmrc.test.api.models.getannualincomesourceforperiod.dividends.UKDividendsAnnual

case class GetAnnualIncomeSourceForPeriodResponse(
        ukSavingsInterestAnnual: Option[Object], ukDividendsAnnual: Option[Object], charitableGivingAnnual: Option[Object])

object GetAnnualIncomeSourceForPeriodResponse {

  implicit val reads:Reads[GetAnnualIncomeSourceForPeriodResponse] = new Reads[GetAnnualIncomeSourceForPeriodResponse]{
    def reads(json: JsValue): JsResult[GetAnnualIncomeSourceForPeriodResponse] = {
      for {
        ukInterestAnnual <- (json \ "ukSavingsInterestAnnual").validateOpt[UKInterestAnnual]
        ukDividendsAnnual <- (json \ "ukDividendsAnnual").validateOpt[UKDividendsAnnual]
        ukCharitableGivingAnnual <- (json \ "ukSavingsInterestAnnual").validateOpt[UKCharitableGivingAnnual]
      } yield GetAnnualIncomeSourceForPeriodResponse(ukInterestAnnual, ukDividendsAnnual, ukCharitableGivingAnnual)
    }
  }

}
