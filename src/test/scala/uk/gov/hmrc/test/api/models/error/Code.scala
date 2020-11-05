package uk.gov.hmrc.test.api.models.error

import play.api.libs.json._

object Code extends Enumeration {

  type Code = Value

  val INVALID_IDTYPE,
  INVALID_IDVALUE,
  NOT_FOUND,
  INVALID_REGIME,
  INVALID_PARAMETER,
  CONFLICT,
  SERVER_ERROR,
  SERVICE_UNAVAILABLE = Value

  implicit val reads: Reads[Code] = new Reads[Code] {
    def reads(json: JsValue): JsResult[Code.Value] = json match {
      case JsString(s) =>
        try {
          JsSuccess(Code.withName(json.as[String]))
        } catch {
          case _: NoSuchElementException =>
            JsError(s"Enumeration expected of type: '${Code.getClass}', but it does not appear to contain the value: '$s'")
        }
      case _ => JsError("String value expected")
    }
  }

}
