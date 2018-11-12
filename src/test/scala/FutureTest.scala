import org.scalatest.{AsyncFunSpec}

import scala.concurrent.Future

/**
  * program: SBTExampleProject
  * description: ${description}
  * author: longyun
  * update 2018-10-23 14:58
  * create: 2018-10-23 14:58
  **/
class FutureTest extends AsyncFunSpec {
  def addAfter2() =Future {
    Thread.sleep(2000)
    (1 to 3).sum
  }
  describe("addAfter2"){
    it("should return 6 after 2 seconds") {
      val test = addAfter2()
      test map (result=> assert(result == 6))
    }
  }
}

object Cpp {
  def main(args: Array[String]): Unit = {
    new FutureTest().execute()
  }
}