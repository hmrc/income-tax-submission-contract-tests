package uk.gov.hmrc.test.api.service

import uk.gov.hmrc.test.api.client.{HttpClient, RequestHeaders, ServiceResponse, StoredResponse}
import uk.gov.hmrc.test.api.conf.TestConfiguration

import scala.concurrent.Future

class GetAnnualIncomeSourceForPeriodConnector(client: HttpClient) extends RequestHeaders {

  val host: String = TestConfiguration.url("des")

  def getIncomeSourceForPeriod(nino: String, incomeSourceType: String, taxYear: String, incomeSourceId: String): Future[StoredResponse] = {
    val url = s"$host/income-tax/nino/$nino/income-source/$incomeSourceType/annual/$taxYear?incomeSourceId=$incomeSourceId"
    client.GET(url, desAuthHeader, envHeader("ist0"))
  }

}
