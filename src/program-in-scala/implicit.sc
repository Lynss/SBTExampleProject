import scala.language.implicitConversions

case class Rectangle(width:Int,height:Int)

implicit class RectangleMaker(width:Int){
  def x(height:Int) = Rectangle(width, height)
}
//like follow

//class RectangleMaker(width:Int){
//  def x(height:Int) = Rectangle(width, height)
//}
//implicit def int2RectangleMaker(width:Int): RectangleMaker = new RectangleMaker(width)

val a = 3 x 4

class PreferredBegin(val preferredBegin:String)
class PreferredEnd(val preferredEnd:String)

object Greeter{

  def greet(g:String)(implicit begin:PreferredBegin,end:PreferredEnd) = begin.preferredBegin + g + end.preferredEnd
}

object lyPrefer{
  implicit val begin: PreferredBegin = new PreferredBegin("$ ")
  implicit val end: PreferredEnd = new PreferredEnd(" .")
}

import lyPrefer._

Greeter.greet("hello")

//def implicitly[T](implicit t:T) = t
//
//def maxList[T](elements:List[T])(implicit ordering: Ordering[T]):T = elements match {
//  case List() => throw new IllegalArgumentException("found an empty List")
//  case List(x) => x
//  case x::rest =>
//    val maxRest = maxList(rest)
//    if(implicitly[Ordering[T]].gt(x, maxRest)) x else maxRest
//}

//view bounds are deprecated,used when the implicit parameter name can be any
def maxList[T <% Ordered[T]](elements:List[T]):T = elements match {
  case List() => throw new IllegalArgumentException("found an empty List")
  case List(x) => x
  case x::rest =>
    val maxRest = maxList(rest)
    if(x > maxRest) x else maxRest
}

maxList(List(3,4,2,1,33,999,123))

val cba = "abc".reverse

