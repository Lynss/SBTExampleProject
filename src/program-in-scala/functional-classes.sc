import scala.annotation.tailrec
import scala.language.implicitConversions

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

  def :+(that: Int):Rational = this + Rational(that)

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

implicit def intToRational(a: Int): Rational  = Rational(a)

val a =  Rational(2, 2)
val b =  Rational(1, 2)
val c=  Rational(2, 2)
a + b
a * b
a * 3
3 * a
a :+ 1

-a
a<b
a>b
a<=b
a>=b
a==b
a==c
