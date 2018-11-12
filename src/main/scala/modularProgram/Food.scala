package modularProgram

object Apple extends Food("Apple")
object Orange extends Food("Orange")
object Cream extends Food("Cream")
object Sugar extends Food("Sugar")
/**
  * program: SBTExampleProject
  * description: ${description}
  * author: longyun
  * update 2018-10-17 17:37
  * create: 2018-10-17 17:37
  **/
abstract class Food(val name:String) {
  override def toString: String = name
}
