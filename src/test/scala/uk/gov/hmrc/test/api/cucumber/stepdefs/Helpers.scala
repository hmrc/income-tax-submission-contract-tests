package uk.gov.hmrc.test.api.cucumber.stepdefs

import io.cucumber.datatable.DataTable

object Helpers {

  def extractMapFromTable(table: DataTable): Map[String, String] = {
    val row = table.asMaps().iterator()
    var mappings: Map[String, String] = Map.empty

    while (row.hasNext) {
      val map = row.next()
      val key: String = map.get("Key")
      val value: String = map.get("Value")
      mappings += (key -> value)
    }

    mappings
  }

}
