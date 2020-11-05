package uk.gov.hmrc.test.api.models.getannualincomesourceforperiod

import play.api.libs.json._

case class Monetary(monetary: JsNumber)

object Monetary{

  implicit val reads: Reads[Monetary] = new Reads[Monetary] {
    def reads(json: JsValue): JsResult[Monetary] = {
      for {
        monetary <- (json \ "monetary").validate[JsNumber]
      } yield Monetary(monetary)
    }
  }

}
