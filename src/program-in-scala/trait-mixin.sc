import scala.collection.mutable.ArrayBuffer

abstract class IntQueue{
  def push(i:Int):Unit
  def pop():Option[Int]
}

class BasicIntQueue extends IntQueue{
  private val buf = new ArrayBuffer[Int]
  override def push(i: Int): Unit = {
    buf += i
    println(buf)
  }
  override def pop():Option[Int] = buf.lastOption
}

val a = new BasicIntQueue
a.push(1)

trait Doubling extends BasicIntQueue{
  override def push(i: Int): Unit = super.push(i * 2)
}

val b = new BasicIntQueue with Doubling
b.push(1)

case class ABC()


