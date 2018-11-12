//封闭类表明子类的信息对你而言都是固定的，这时候就不需要case _ 了 ，并提示你部分可能缺失的匹配
sealed trait Notification

case class SMS(caller: String, message: String) extends Notification

case class Email(email: String, title: String, message: String) extends Notification

val specialOne = Seq("123@163.com")

def showNotification(x: Notification) = (x : @unchecked ) match {
  case Email(email, title, _) =>
    s"You got an email from $email with title: $title"
//  case SMS(number, message) =>
//    s"You got an SMS from $number! Message: $message"
//  case _ => "unknown notification"
}

def showSpecialNotification(x: Notification) = x match {
  case Email(email, _, _) if specialOne contains email =>
    "you got a email from a special one"
  case SMS(number, _) if specialOne contains number =>
    "you got a SMS from a special one"
  case other => showNotification(other)
}

//sealed class ,so no need for case all
def showMessageType(x:Notification)= x match {
  case _:Email =>println("you got a email")
  case _:SMS =>println("you got a sms ")
}

val someSms = SMS("12345", "Are you there?")
val someEmail = Email("123@163.com", "this is a title", "content")

println(showSpecialNotification(someSms))
println(showSpecialNotification(someEmail))

println(showMessageType(someSms))
println(showMessageType(someEmail))
