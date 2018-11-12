import scala.collection.immutable.{TreeMap, TreeSet}
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.collection.mutable

val a = ListBuffer(1)
a += 2
a += 3
0 +=: a

Predef

val b = ArrayBuffer(1)
b += 2
b += 3
0 +=: b

val c = "see See, run. Run Test! what"
val d:mutable.Set[String] = c.split("[ !,.]+").map(_.toLowerCase).to[mutable.Set]
val e = List("run", "fuck")
d | e.toSet
d & e.toSet
d - "run"
d ++ List("a","b")
d -- List("run","b")

val f = mutable.TreeMap.empty[Int, Int]
f(1) = 1
f(2) = 4
f.put(3,9)
f += (3 -> 6)
f ++= List(3 -> 9, 4 -> 16)
f += Tuple2(5,25)
val g = (6,36)
f += g
f += {(7,49)}

val h = TreeSet(3,2,1,4,56,73,23)
val i = TreeMap("b"->1,"ab"->2)