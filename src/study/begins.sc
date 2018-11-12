
class Point {
  private var _x = 0
  private var _y = 0
  val boundary = 100

  def x = _x

  def y = _y

  private def printWarning = println("out of boundary")

  def x_=(newValue: Int) =
    if (newValue < boundary) _x = newValue else printWarning

  def y_=(newValue: Int) =
    if (newValue < boundary) _y = newValue else printWarning
}

trait Iterator[A] {
  def hasNext: Boolean

  def next: A
}

class IntIterator(val to: Int) extends Iterator[Int] {
  var current = 0

  override def hasNext: Boolean = current < to

  override def next: Int =
    if (hasNext) {
      val temp = current
      current += 1
      temp
    } else
      0
}

abstract class AbsIterator {
  type T

  def hasNext: Boolean

  def next: T
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit) = while (hasNext) f(next)
}

class StringIterator(s: String) extends AbsIterator {
  override type T = Char
  var i = 0

  override def hasNext = i < s.length

  override def next = {
    val char = s charAt i
    i += 1
    char
  }
}


def addTwice(a: Int)(c: Int) = a + c
val d = addTwice(1) _
println(d(3))

val e = List(1, 2, 3, 4, 5, 6, 7)
val f = e.foldLeft(List[Int]()) _
println(f(_ :+ _))

val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
println((1 /: numbers) (_ + _))

// Used in place of foldLeft

class RichStringIterator extends StringIterator("niubility") with RichIterator

val test = new RichStringIterator
test foreach println

