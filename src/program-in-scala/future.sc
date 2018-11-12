
import scala.concurrent.{Await, Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}

val d = Future.successful {
  //将会阻塞，直到返回
  Thread.sleep(2000)
  1
}

d onComplete {
  case Success(res) => println(res)
}

val thenValue = d andThen {
  case Success(res) => Future.successful(res)
}
thenValue.value

val e = Future.failed {
  new Exception
}
val f = Future.fromTry {
  Success(1)
}
val g = Future.fromTry {
  Failure(new Exception)
}
val a = Future {
  Thread.sleep(1000)
  1
}

val b = a.map(_ + 1)

val c = for {
  x <- a
  y <- b
} yield x + y
Thread.sleep(1000)
c.value

val h = Promise[Int]
val i = h.future
i.value
//h.success(1)
h.complete(Failure(new Exception("a")))
i.value

val j = Future {
  1
}
j.failed

val k = j.filter(res => res > 0)
val l = for (res <- j if res < 0) yield res
k.value
l.value

val m = j.collect {
  case x if x < 0 => -1
  case y if y > 0 => 1
}
m.value

val n = Future {
  1 / 0
}
n.value
n.failed

n.fallbackTo(j)
n.recover {
  case e: ArithmeticException => -1
}
n.recoverWith {
  case e: ArithmeticException => j
}
n.transform(res => res * -1, ex => new Exception("see cause", ex))
val o = n.transform {
  case Success(res) => Success(res * -1)
  case Failure(_) => Success("transformed")
}

val p = o zip j
o.value

val q = for (i <- 1 to 5) yield Future(i)
val r = Future.foldLeft(q)(10)(_ * _)
r.value

val s = Future.sequence(q)
s.value

n.foreach(println)
o.foreach(println)

val t = o.zipWith(j) {
  case (x, z) => println(x + z.toString)
}
t.value

val u = n.transformWith {
  case Success(res) => Future {
    throw new Exception(res.toString)
  }
  case Failure(ex) => Future {
    21 + 21
  }
}
o.value
u.value

val v = Future {
  Thread.sleep(10000)
  1
}

import scala.concurrent.duration._

val w = Await.result(v, 11.seconds)
println(2)

val x = Try(new Exception("123")).toOption
