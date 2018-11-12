package modularProgram

trait FoodCategories {
  case class FoodCategory(name: String, ingredients: List[Food])
  def allCategories: List[FoodCategory]
}
