trait User {
  def username: String
}

trait Introduce {
  this: User =>
  def introduce(): Unit = println(s"my name is $username")
}

class IntroduceMan(val _username :String) extends Introduce with User{
  def username = s"real ${_username}"
}

val tester =new IntroduceMan("ly")
tester.introduce()