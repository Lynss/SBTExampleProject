package modularProgram
object FruitSalad extends Recipe(
  "fruit salad",
  List(Apple, Orange, Cream, Sugar),
  "Stir it all together."
)

/**
  * program: SBTExampleProject
  * description: ${description}
  * author: longyun
  * update 2018-10-17 17:37
  * create: 2018-10-17 17:37
  **/
abstract class Recipe (val name:String,val ingredients:List[Food],val introduction:String){
  override def toString: String = name
}

