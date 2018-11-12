import scala.xml._
val a = <test>hello,{<world name="test">{"world"}<c/></world>}</test>
a.text
a \ "world"
a \\ "c"
a \ "world" \"@name"

abstract class CCTherm {
  val description: String
  val yearMade: Int
  val dateObtained: String
  val bookPrice: Int // in US cents
  val purchasePrice: Int // in US cents
  val condition: Int // 1 to 10
  override def toString = description

  def toXML =
    <cctherm>
      <description>{description}</description>
      <yearMade>{yearMade}</yearMade>
      <dateObtained>{dateObtained}</dateObtained>
      <bookPrice>{bookPrice}</bookPrice>
      <purchasePrice>{purchasePrice}</purchasePrice>
      <condition>{condition}</condition>
    </cctherm>

}

def fromXML(node: Node): CCTherm =
  new CCTherm {
    val description = (node \"description").text
    val yearMade = (node \"yearMade").text.toInt
    val dateObtained = (node \"dateObtained").text
    val bookPrice = (node \"bookPrice").text.toInt
    val purchasePrice = (node \"purchasePrice").text.toInt
    val condition = (node \"condition").text.toInt
  }

val therm = new CCTherm {
  val description = "hot dog #5"
  val yearMade = 1952
  val dateObtained = "March 14, 2006"
  val bookPrice = 2199
  val purchasePrice = 500
  val condition = 9
}
val thermXml = therm.toXML

fromXML(thermXml)

XML.save("D:\\test.xml",thermXml)

val test =XML.loadFile("D:\\test.xml")

val catalog =
  <catalog>
    <cctherm>
      <description>hot dog #5</description>
      <yearMade>1952</yearMade>
      <dateObtained>March 14, 2006</dateObtained>
      <bookPrice>2199</bookPrice>
      <purchasePrice>500</purchasePrice>
      <condition>9</condition>
    </cctherm>
    <cctherm>
      <description>Sprite Boy</description>
      <yearMade>1964</yearMade>
      <dateObtained>April 28, 2003</dateObtained>
      <bookPrice>1695</bookPrice>
      <purchasePrice>595</purchasePrice>
      <condition>5</condition>
    </cctherm>
  </catalog>

catalog match {
  case <catalog>{therms @ _*}</catalog>=>
    for (therm @ <cctherm>{_*}</cctherm> <- therms)
      println("processing: " +
        (therm \"description").text)
}