class Stack[A]{
  private var elements:List[A] = Nil
  def push(x:A) = {elements = x ::elements }
  def peek = elements.head
  def pop = {
    val top = peek
    elements=elements.tail
    top
  }
}

class Fruit
case class Apple(name:String) extends Fruit
case class Banana(name:String) extends Fruit

val fruitStack = new Stack[Fruit]
fruitStack.push(Banana("Banana1"))
fruitStack.push(Apple("apple"))
fruitStack.push(Banana("Banana2"))
println(fruitStack.pop)
println(fruitStack.pop)