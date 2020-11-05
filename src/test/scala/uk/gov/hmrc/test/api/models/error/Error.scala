package uk.gov.hmrc.test.api.models.error

import play.api.libs.json.{JsResult, JsValue, Reads}
import uk.gov.hmrc.test.api.models.error.Code.Code

case class Error(code: Code, reason: String) {

  val codeStr: String = code.toString

}

object Error {

  implicit val reads: Reads[Error] = new Reads[Error] {
    def reads(json: JsValue): JsResult[Error] = {
      for {
        code <- (json \ "code").validate[Code]
        reason <- (json \ "reason").validate[String]
      } yield Error(code, reason)
    }
  }

}
