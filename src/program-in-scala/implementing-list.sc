import scala.collection.immutable.{Queue, TreeSet}
import scala.collection.mutable

List(3,4).:::(List(1, 2))

val a = List(3->6,1->2,2->4)
a.toMap

val b = Map(a: _*)
val xs = List(1, 2, 3, 4,5)
val ys = List(2, 4, 6, 8,10)
xs.groupBy(_>3)

val gip = xs grouped 3
gip.next()
gip.next()

val sit = xs sliding 3
sit.next()
sit.next()
sit.next()

xs zip ys

val c = Set(1, 2, 3)
c(2)
c(4)

val d = mutable.Map(1->1)
d+(2->4,3->9)
d++List(2->4,3->9)
d++ List((2,4), (3, 9))
(2->4).isInstanceOf[(Int, Int)]
d
d.getOrElseUpdate(2,4)
d

val s1 = 1#::2 #::3 #:: Stream.empty
val s2 = s1 #:::Stream.empty
s1(2)
def fibStream(a:Int,b:Int):Stream[Int] = a#::fibStream(b,a+b)
fibStream(0,1).take(7).toList

val v1 = 1 +: 2 +: Vector.empty
val v2 = Vector.empty :+1 :+ 2
100 +: v1
v1(1)
v1.updated(1,4)
v1
IndexedSeq(1,2,3)

val q1 = Queue.empty[Int]
val q2  = q1.enqueue(1)
val q3 = q2.enqueue(List(2, 3))
val q4 = q3.dequeue

1 until 21 by 5 foreach println
1 to 21 by 5 foreach println

val rb1 = TreeSet.empty[Int]
val rb2 = rb1 + 1+ 3 + 2
rb2(3)

