package example

/**
  * program: SBTExampleProject
  * description: ${description}
  * author: longyun
  * update 2018-05-17 17:17
  * create: 2018-05-17 17:17
  **/
object Main extends App {
  val ages = Seq(1, 2, 3, 5, 456, 78, 23)
  println(s"The oldest one is ${ages.max}")
}

object Solution {
  def mySqrt(x: Int): Int = {
    if (x < 2) {
      return x
    }

    def binaryQuery(i: Int, j: Int): Int = {
      val mid = (j - i) / 2 + i
      if (mid <= x / mid && mid + 1 > x / (mid + 1)) {
        return mid
      }
      if (x / mid < mid) {
        binaryQuery(i, mid)
      } else {
        binaryQuery(mid, j)
      }
    }

    val result = binaryQuery(0, x)
    result
  }


  def main(args: Array[String]): Unit = {
    val test = 2147395600
    println(math.sqrt(test))
    println(Solution.mySqrt(test))
  }
}


abstract class Monoid[A] {
  def sum(x: A, y: A): A

  def unit: A
}


