import org.scalatest.FunSuite

/**
  * program: SBTExampleProject
  * description: ${description}
  * author: longyun
  * update 2018-05-17 17:48
  * create: 2018-05-17 17:48
  **/
class CubeCalculatorTest extends FunSuite {
  import org.scalatest.DiagrammedAssertions.{assert=>dAssert,_}
  test("CubeCalculator.cube") {
    assert(new CubeCalculator().cube(3) == 28)
  }
  test("CubeCalculator.zero ") {
    assertResult(0) {
      new CubeCalculator().cube(1)
    }
  }
  test("a list should have element 4") {
    dAssert(List(1, 2, 3).contains(4))
  }
  test("a IllegalArgumentException should be thrown"){
    assertThrows[IllegalArgumentException](throw new IllegalArgumentException)
  }
  test("a exception has been intercepted"){
    val caught =
      intercept[ArithmeticException] {
        1 / 0
      }
    assert(caught.getMessage == "/ by zero")
  }
}

object App {
  def main(args: Array[String]): Unit = {
    new CubeCalculatorTest().execute()
  }
}