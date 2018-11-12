import scala.annotation.tailrec

var i = 10

@tailrec
def whileLoop(condition: => Boolean)(body: => Unit): Unit = {
  if (condition) {
    body
    whileLoop(condition)(body)
  }
}


whileLoop(i > 0) {
  println(i)
  i -= 1
}

val assertionEnable = false

def byNameAssert(predicate: => Boolean): Unit = {
  if (assertionEnable && !predicate) {
    throw new AssertionError
  }
}

def boolAssert(predicate: Boolean): Unit = {
  if (assertionEnable && !predicate) {
    throw new AssertionError
  }
}

//won't console 1 because it's used by name
byNameAssert{
  println("1")
  5 > 3
}

boolAssert{
  println("1")
  5 > 3
}