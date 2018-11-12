import scala.util.matching.Regex

"1.".split("""\.""")
"1.".split("\\.")
"""\.""".r
"\\.".r
new Regex("""\.""")

val input = "-1.0 to 99 by 3"
val test = """(-)?(\d+)(\.\d*)?""".r

for(s <-test findAllIn input) println(s)

test findFirstIn input

test findPrefixOf input

val test(sign,integerPart,decimalPart) = "-1.23"

