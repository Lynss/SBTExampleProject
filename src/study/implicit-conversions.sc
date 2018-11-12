import scala.language.implicitConversions

List(1, 2, 3,4) > List(1, 2, 4) //if no implicit conversion here,compile error

implicit def list2ordered[A](x: List[A]): Ordered[List[A]] = (that: List[A]) => x.length - that.length


