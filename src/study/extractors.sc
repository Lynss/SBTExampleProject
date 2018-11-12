import scala.util.matching.Regex

object UpperCase {
  def unapply(arg: String): Boolean = arg.toUpperCase == arg
}

"DI" match {
  case x @ UpperCase() => "matched UpperCase"
  case _ => "Not matched"
}

"DI" match {
  case UpperCase() => "matched UpperCase"
  case _ => "Not matched"
}

object ExpandedEmail {
  def unapplySeq(s:String):Option[(String,Seq[String])] =     s split "@" match {
    case Array(name,domains) => Some(name,domains.split("\\.").reverse)
    case _=>None
  }
}

val ExpandedEmail(tom,top,rest @ _*) = "tom@support.epfl.ch"

val List(x,y @ _*)=List(1,2,3)


//样本类和抽取器不同,但同样可以提供模式匹配
case class Person(name:String,sex:String)

val Person(a,b) = Person("ly","male")