package pc.exercise

import org.scalatest.funsuite.AnyFunSuite
import pc.exercise.PNReaderWriters.Place.{P1, P5, P6, P7}
import pc.exercise.PNReaderWriters.pnRW
import pc.utils.MSet
import org.scalatest.matchers.should.Matchers

class SafetyCheckerTest extends AnyFunSuite with Matchers:

  test("Test isSafe") {
    SafetyChecker.isSafe(pnRW, MSet(P1, P5), MSet(P6, P7), 100) shouldBe true
  }

  test("Test isSafeMany") {
    SafetyChecker.isSafeMany(pnRW, MSet(P1, P5), Seq(MSet(P6, P7), MSet(P6, P7)), 100) shouldBe true
  }
