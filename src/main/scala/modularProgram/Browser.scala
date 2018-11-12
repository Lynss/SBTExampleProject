package modularProgram

/**
  * program: SBTExampleProject
  * description: ${description}
  * author: longyun
  * update 2018-10-17 17:39
  * create: 2018-10-17 17:39
  **/
abstract class Browser {
  val database: Database

  def recipesUsing(food: Food) =
    database.allRecipes.filter(recipe =>
      recipe.ingredients.contains(food))

  def displayCategory(category: database.FoodCategory) = {
    println(category)
  }
}
