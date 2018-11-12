import scala.annotation.tailrec

object Rational{
  def apply(n: Int, d: Int): Rational = new Rational(n, d)
  def apply(n: Int): Rational = new Rational(n)
}

class Rational(n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)
  val g = greatestCommonDivisor(n, d)
  val numerator = n / g
  val denominator = d / g

  def this(numerator: Int) = this(numerator, 1)

  def +(that: Rational) =
    new Rational(numerator * that.denominator + that.numerator * denominator, denominator * that.denominator)


  def *(that: Rational) =
    new Rational(numerator * that.numerator, denominator * that.denominator)

  def *(that: Int): Rational = this *  Rational(that)

  def unary_-(): Rational =  Rational(-numerator, denominator)

  override def toString = s"$numerator/$denominator"

  @tailrec
  private def greatestCommonDivisor(a: Int, b: Int): Int = if (b == 0) a else greatestCommonDivisor(b, a % b)

  override def compare(that: Rational) = numerator * that.denominator - denominator * that.numerator

  override def equals(that: scala.Any) = that match {
    case rationalNumber:Rational => (this compare rationalNumber) == 0
    case _ => false
  }
}

val fruits = List("apple", "orange", "banana")
val juices = List("coca", "tea")
val List(a, b, c) = fruits

"abcde" apply 2
"abcde".indices

fruits drop 2
fruits take 2
fruits splitAt 2
val d :: e :: rest = fruits

//插入算法
def insertSort(x: List[Int]): List[Int] = x match {
  case Nil => Nil
  case y :: ys => insert(y, insertSort(ys))
}

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case Nil => List(x)
  case y :: ys => if (x < y) x :: xs else y :: insert(x, ys)
}

//归并算法
def merge[A<:Ordered[A]](xs: List[A], ys: List[A]): List[A] = (xs, ys) match {
  case (xsl, Nil) => xsl
  case (Nil, ysl) => ysl
  case (x :: xsl, y :: ysl) =>
    if (x < y) {
      x :: merge(xsl, ys)
    } else {
      y :: merge(xs, ysl)
    }

}

def msort[A<:Ordered[A]](xs: List[A]): List[A] = {
  xs match {
    case Nil => Nil
    case y :: ys if ys.isEmpty => List(y)
    case _ :: ys if ys.nonEmpty =>
      val n = xs.length / 2
      val (first, second) = xs splitAt n
      merge[A](msort(first), msort(second))
  }
}

def quickSort(xs: List[Int]): List[Int] = xs match {
  case y :: ys if ys.nonEmpty =>
    ys.partition(_ < y) match {
      case (before, after) => quickSort(before) ::: y :: quickSort(after)
    }
  case ys => ys
}

val g: List[Int] = List(6, 202, 100, 301, 38, 8, 1)
val i: List[Int] = List(2, 3, 4, 5, 6, 7, 8)
val h: List[List[Int]] = List(List(6, 202, 100), List(301, 38, 8, 1))
val l : List[Rational] =  List(Rational(1,3),Rational(2,4), Rational(3) )

println(l)
g.sortWith(_ < _) == insertSort(g)
g.sortWith(_ < _) == quickSort(g)
l.sortWith(_ < _) == msort[Rational](l)
g.span(_ < 300)
g.takeWhile(_ < 300)
g.dropWhile(_ < 300)
g.forall(_ > 0)
g.exists(_ < 0)
(0 /: g) (_ + _) == 656
(g :\ 0) (_ + _) == 656
h.flatten == h.flatMap(xs => xs)
g.reverse
List.fill(5)("a")
List.fill(3,2)('a')

List.tabulate(3)(math.pow(_,2))
List.tabulate(5, 5)((first, second) => {
   first*second
})
List.concat(g,i)
val zipped = g zip i
zipped.map{
  case (x,y)=>x*y
}
(g,i).zipped.map(_*_)
(g,i).zipped.flatMap((a,b)=>{
  List(a,b)
})

val test:List[Int]=>List[Int] = identity _
h.flatten ==h.flatMap(test)
h.flatten ==h.flatMap(identity _)
h.iterator.foreach(println)