package uk.gov.hmrc.test.api.models.getannualincomesourceforperiod.interest

import play.api.libs.json._

case class UKInterestAnnual(savingsInterestAnnualIncome: SavingsInterestAnnualIncome)

object UKInterestAnnual {

  implicit val reads: Reads[UKInterestAnnual] = new Reads[UKInterestAnnual] {
    def reads(json: JsValue): JsResult[UKInterestAnnual] = {
      for {
        savingsInterestAnnualIncome <- (json \ "savingsInterestAnnualIncome").validate[SavingsInterestAnnualIncome]
      } yield UKInterestAnnual(savingsInterestAnnualIncome)
    }
  }
}
