case class User(name: String, age: Int)

val userBase = List(User("ly", 21), User("xf", 19),
  User("dxx", 22), User("hmx", 18))

val twentySomethings=  for(user <- userBase if user.age>=20) yield user.name

twentySomethings.foreach(println)

def foo(i:Int,j:Int) ={
  for(x <- 0 until i;
      y <- x until i if x+y == j)
    yield (x,y)

//  print(x,y)
}

//foo(10,10)

foo(10,10) foreach {test=>println(s"(${test._1},${test._2})")}
foo(10,10) foreach (test=>println(s"(${test._1},${test._2})"))
foo(10,10) foreach ({test=>println(s"(${test._1},${test._2})")})
foo(10,10) foreach println
foo(10,10) foreach {case(i,j)=>println(i,j)}


