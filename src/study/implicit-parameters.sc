import scala.annotation.tailrec

abstract class Monoid[A] {
  def sum(x: A, y: A): A

  def unit: A
}

@tailrec
class ImplicitTester {
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A = {
    if (xs.isEmpty) {
      m.unit
    } else {
      m.sum(xs.head, sum(xs.tail))
    }
  }
}

implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
  override def sum(x: Int, y: Int) = x + y

  override def unit = 0
}

implicit val stringMonoid: Monoid[String] = new Monoid[String] {
  override def sum(x: String, y: String) = x concat y

  override def unit = ""
}
val tester = new ImplicitTester

println(tester.sum(List(1, 2, 3)))
println(tester.sum(List[Int]()))
println(tester.sum[String](List()))
println(tester.sum(List("1", "2", "3")))


