trait Node[+A] {
  def prepend[U >: A](a: U): Node[U]
}

case class ListNode[+A](h: A, t: Node[A]) extends Node[A] {
  def prepend[U >: A](a: U) = ListNode(a, this)

  def head = h

  def tail = t
}

case class Nil[+B]() extends Node[B] {
  def prepend[U >: B](elem: U) = ListNode(elem, this)
}

trait Bird
case class AfricanSwallow() extends Bird
case class EuropeanSwallow() extends Bird

val africanSwallowList= ListNode[AfricanSwallow](AfricanSwallow(), Nil())
val birdList: Node[Bird] = africanSwallowList
birdList.prepend(new EuropeanSwallow)
africanSwallowList.head
africanSwallowList.tail