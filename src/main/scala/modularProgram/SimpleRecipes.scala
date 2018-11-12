package modularProgram

trait SimpleRecipes {
  this:SimpleFoods=>
  object FruitSalad extends Recipe(
    "fruit salad",
    List( Pear),
    "Mix it all together."
  )
  def allRecipes = List(FruitSalad)
}
