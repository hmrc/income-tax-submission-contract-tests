package uk.gov.hmrc.test.api.service

import uk.gov.hmrc.test.api.client.{HttpClient, RequestHeaders, StoredResponse}
import uk.gov.hmrc.test.api.conf.TestConfiguration

import scala.concurrent.Future

class CreateOrUpdateAnnualIncomeSourceConnector(client: HttpClient) extends RequestHeaders {

  val host: String = TestConfiguration.url("des")

  def postCreateOrUpdateAnnualIncomeSource(nino: String, incomeSourceType: String, taxYear: String, body: String): Future[StoredResponse] = {
    val url = s"$host/income-tax/nino/$nino/income-source/$incomeSourceType/annual/$taxYear"
    client.POST(url, body, desAuthHeader, envHeader("ist0"))
  }

}
