import scala.util.Random

object CustomID{
  def apply(name:String) = s"$name--${Random.nextLong}"

  def unapply(customID: String): Option[String] =customID split "--" match {
    case idArray if idArray.tail.nonEmpty  => Some(idArray.head)
    case _ =>None
  }
}

val a = CustomID("ly")

val CustomID(name) = a

println(name)

var c =Set(1,3) //default immutable c
c += 4
println(c)
a match {
  case CustomID(b) => println(b)
  case _ => println("Could not extract a CustomerID")
}

