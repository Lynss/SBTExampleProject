package modularProgram

/**
  * program: SBTExampleProject
  * description: ${description}
  * author: longyun
  * update 2018-10-17 17:39
  * create: 2018-10-17 17:39
  **/
abstract class Database extends FoodCategories{
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String): Option[Food] =
    allFoods.find(food=>true)
}
