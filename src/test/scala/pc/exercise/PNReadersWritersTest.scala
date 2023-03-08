package pc.exercise

import org.scalatest.funsuite.AnyFunSuite
import pc.exercise.PNReaderWriters.Place.{P1, P5, P6, P7}
import pc.exercise.PNReaderWriters.pnRW
import pc.utils.MSet
import org.scalatest.matchers.should.Matchers

class PNReadersWritersTest extends AnyFunSuite with Matchers:

  test("Test pnRW"){
    pnRW.paths(MSet(P1, P5), 100).toList.flatten.contains(MSet(P6, P7)) shouldBe false
    pnRW.paths(MSet(P1, P5), 100).toList.flatten.contains(MSet(P1, P5)) shouldBe true
  }