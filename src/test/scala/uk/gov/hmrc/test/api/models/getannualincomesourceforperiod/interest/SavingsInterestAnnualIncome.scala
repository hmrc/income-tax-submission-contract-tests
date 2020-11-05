package uk.gov.hmrc.test.api.models.getannualincomesourceforperiod.interest

import play.api.libs.json._

case class SavingsInterestAnnualIncome(items: Items)

object SavingsInterestAnnualIncome{

  implicit val reads: Reads[SavingsInterestAnnualIncome] = new Reads[SavingsInterestAnnualIncome] {
    def reads(json: JsValue): JsResult[SavingsInterestAnnualIncome] = {
      for {
        items <- (json \ "items").validate[Items]
      } yield SavingsInterestAnnualIncome(items)
    }
  }
}
