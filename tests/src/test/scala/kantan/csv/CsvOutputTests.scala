package kantan.csv

import java.io._
import kantan.csv.laws.discipline.arbitrary._
import kantan.csv.ops._
import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import scala.io.Codec

class CsvOutputTests extends FunSuite with GeneratorDrivenPropertyChecks {
  test("CSV data should be correctly written to an output stream (bit by bit)") {
    forAll(csv) { csv ⇒
      val out = new ByteArrayOutputStream()

      csv.foldLeft(out.asCsvWriter[List[String]](','))(_ write _).close()

      assert(new String(out.toByteArray, Codec.UTF8.charSet) == csv.asCsv(','))
    }
  }

  test("CSV data should be correctly written to an output stream (in bulk)") {
    forAll(csv) { csv ⇒
      val out = new ByteArrayOutputStream()

      out.writeCsv(csv, ',')

      assert(new String(out.toByteArray, Codec.UTF8.charSet) == csv.asCsv(','))
    }
  }

  test("CSV data should be correctly written to a writer (bit by bit)") {
    forAll(csv) { csv ⇒
      val out = new StringWriter()

      csv.foldLeft(out.asCsvWriter[List[String]](','))(_ write _).close()

      assert(out.toString == csv.asCsv(','))
    }
  }

  test("CSV data should be correctly written to a writer (in bulk)") {
    forAll(csv) { csv ⇒
      val out = new StringWriter()

      out.writeCsv(csv, ',')

      assert(out.toString == csv.asCsv(','))
    }
  }
}