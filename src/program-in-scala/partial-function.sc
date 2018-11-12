//will console a warning when compile because may miss match Nil
val second: List[Int] => Int = {
  case x :: y :: _ => y
}

val a = List(1, 2, 3)
val b = Nil

second(a)
//second(b)


val secondPartial: PartialFunction[List[Int],Int] = {
  case x :: y :: _ => y
}
secondPartial.isDefinedAt(a)
secondPartial.lift(b)
secondPartial.isDefinedAt(b)
secondPartial(a)
//secondPartial(b)

val test =new PartialFunction[List[Int], Int] {
  def apply(xs: List[Int]) = xs match {
    case x :: y :: _ => y
  }
  def isDefinedAt(xs: List[Int]) = xs match {
    case x :: y :: _ => true
    case _ => false
  }
}
test.isDefinedAt(a)
test.isDefinedAt(b)

test(a)
//test(b)