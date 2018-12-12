import scala.language.implicitConversions

class Test(){
  def test():Unit = println("what the fuck")
}

class RichFoo(val self:  Test) extends Proxy {
  def newMethod = "do something cool"
  def newTest(): Unit = {
    println("before")
    self.test()
    println("after")
  }
}

object RichFoo {
  def apply(foo:  Test) = new RichFoo(foo)
  implicit def foo2richFoo(foo: Test): RichFoo = RichFoo(foo)
  implicit def richFoo2foo(richFoo: RichFoo):  Test = richFoo.self
}


val a =new Test()
RichFoo(a).test()