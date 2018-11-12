class Email(var username: String, var domainName: String)

object Email {
  def fromString(emailString: String): Option[Email] = emailString split "@" match {
    case Array(username, domainName) => Some(new Email(username, domainName))
    case _ => None
  }
}

val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
scalaCenterEmail match {
  case Some(email) => println(
    s"""Registered an email
       |Username: ${email.username}
       |Domain name: ${email.domainName}
     """)
  case None => println("Error: could not parse email")
}

