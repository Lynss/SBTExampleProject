def printArgs(args:String* ): Unit = args foreach println
val arguments = List("oh","ha","ha")
printArgs("oh","ha","ha")
printArgs(arguments: _*)

