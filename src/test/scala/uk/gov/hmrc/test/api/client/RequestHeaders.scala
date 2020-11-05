package uk.gov.hmrc.test.api.client

trait RequestHeaders {

  val jsonHeader: (String, String) = ("Content-Type", "application/json")

  val adminHeader: (String, String) = ("Authorization", "Basic dGVzdGFkbWluOnRlc3RhZG1pbiQxMjM=")

  val desAuthHeader: (String, String) = ("Authorization", "Bearer EvYRlYH8AS_hZGw32ffqJ25Mz04a")

  def envHeader(env: String): (String, String) = ("Environment", env)

}
