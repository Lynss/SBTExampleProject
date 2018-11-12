def multiTable(): Unit = {
  val multiTableString: String = (1 until 10).map(i => {
    (1 to i).map({
      case end if end == i => s"$end * $i = ${end * i}\n"
      case j => s"$j * $i = ${j * i} "
    }).mkString
  }).mkString
  println(multiTableString)
}

multiTable()