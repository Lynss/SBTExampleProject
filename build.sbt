name := "SBTExampleProject"

version := "0.1"

scalaVersion := "2.12.6"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5" % "test"
val akka = "com.typesafe.akka" %% "akka-actor" % "2.5.17"

libraryDependencies ++= Seq(scalaTest, akka)

