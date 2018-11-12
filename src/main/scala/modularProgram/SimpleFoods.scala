package modularProgram

trait SimpleFoods {
  object Pear extends Food("Pear")
  def allFoods = List( Pear)
  def allCategories = Nil
}
