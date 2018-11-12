import org.scalatest.{FlatSpec, Matchers}

case class Person(name:String,gf:Option[Person])
/**
  * program: SBTExampleProject
  * description: ${description}
  * author: longyun
  * update 2018-09-27 14:15
  * create: 2018-09-27 14:15
  **/
class PersonSpecTest extends FlatSpec with Matchers{
  "a person" can "have a name" in {
    val ly = Person("ly",None)
    ly.name should be ("ly")
  }

  it should "throw a NoSuchElementException when you ask his gf" in {
    an [NoSuchElementException] should be thrownBy {
      val doge = Person("doge", None)
      doge.gf.get
    }
  }
}

import org.scalatest._
class TVSetSpec extends FeatureSpec with GivenWhenThen {
  feature("TV power button") {
    scenario("User presses power button when TV is off") {
      Given("a TV set that is switched off")
      When("the power button is pressed")
      Then("the TV should switch on")
      pending
    }
  }
}

object Bpp {
  def main(args: Array[String]): Unit = {
    new PersonSpecTest().execute()
    new TVSetSpec().execute()
  }
}

