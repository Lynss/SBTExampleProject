import java.io.File

import scala.io.Source

val files = new File(".").listFiles()

def fileLines(file: File) = Source.fromFile(file).getLines().toList

def grep(pattern:String) = for {
  file <- files
  if file.getName endsWith ".sc"
  line <- fileLines(file)
  trimmed = line.trim
  if trimmed.matches(pattern)
} {
  println(file + ": " + trimmed)
}

grep("def.*")