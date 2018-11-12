//import org.scalatest.WordSpec
//import org.scalatest.prop._
//import org.scalatest.MustMatchers._
//
//class PropertyTest extends WordSpec with PropertyChecks {
//
//  def sort(x:List[Int]):List[Int] = x match {
//    case Nil => Nil
//    case y::ys => insert(y, sort(ys))
//  }
//
//  def insert(x:Int,xs:List[Int]):List[Int] = xs match {
//    case Nil => List(x)
//    case y::ys => if(x<y) x::xs else y:: insert(x, ys)
//  }
//
//  "sort " must {
//    "sort a list asc" in {
//      forAll {
//        n:List[Int] => {
//          n.sortWith(_<_) must be (sort(n))
//        }
//      }
//    }
//  }
//}
//
//
//object Cpp {
//  def main(args: Array[String]): Unit = {
//    new PropertyTest().execute()
//  }
//}
//
