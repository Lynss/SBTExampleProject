import java.awt.event.ActionEvent

import javax.swing.JButton

trait Fruit {
  val name: String
  val price: Int
  require(price > 0)
  var store: String
}

//可以用val去重载def
class Apple extends Fruit {
  override val name = "apple"

  override val price = 1

  override var store = "apple_1"
}

val p = 1

//it will throw a IllegalArgumentException because of the initial Int value is 0 which doesn't match the requirement price>0
//val a1 = new Fruit {
//  override val name: String = "apple"
//
//  override val price: Int = p * 2
//
//  override var store: String = "apple_1"
//}
//
val a2 = new Fruit {
  override val name: String = "apple"

  override lazy val price: Int = p * 2

  override var store: String = "apple_1"
}
a2.price


val a3 = new {
  override val name: String = "a"
  override val price: Int = p * 2
  override var store: String = "b"
} with Fruit

object Demo1 {
  val x = {
    println("initial x")
    "test"
  }
}

object Demo2 {
  lazy val x = {
    println("initial x")
    "test"
  }
}

Demo1
Demo2

Demo1.x
Demo2.x

class Food

abstract class Animal {
  type SuitableFood <: Food

  def eat(food: SuitableFood): Unit
}

class Grass extends Food

class Cow extends Animal {
  override type SuitableFood = Grass

  override def eat(food: SuitableFood): Unit = {
    println("a cow eat grass")
  }
}

val a = new Cow
val b = new Cow
a.eat(new b.SuitableFood)

class Outer {

  class Inner

}

val o1 = new Outer
val o2 = new Outer

val i1 = new o1.Inner
val i2 = new o1.Inner

i1.getClass == i2.getClass //true?

object Color extends Enumeration {
  val RED = Value("red")
  val YELLOW = Value("yellow")
  val BLUE = Value("blue")
}

Color.values.foreach(println)

println(Color(0))
println(Color.RED)
Color.RED == Color(0)

object Converter {
  var exchangeRate = Map(
    "USD" -> Map("USD" -> 1.0, "EUR" -> 0.7596,
      "JPY" -> 1.211, "CHF" -> 1.223),
    "EUR" -> Map("USD" -> 1.316, "EUR" -> 1.0,
      "JPY" -> 1.594, "CHF" -> 1.623),
    "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272,
      "JPY" -> 1.0, "CHF" -> 1.018),
    "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160,
      "JPY" -> 0.982, "CHF" -> 1.0)
  )
  exchangeRate.get("USD")
}

abstract class CurrencyZone {

  abstract class AbstractCurrency {
    val amount: Long
    val designation: String

    private def decimals(n: Long): Int =
      if (n == 1) 0 else 1 + decimals(n / 10)

    override def toString: String =
      (amount.toDouble / currencyUnit.amount.toDouble).formatted("%." + decimals(currencyUnit.amount) + "f") + " " + designation

    def from(that: CurrencyZone#AbstractCurrency) = make((that.amount * Converter.exchangeRate(that.designation)(designation)).toLong)

    def +(that: Currency): Currency = make(amount + that.amount)

    def *(multiple: Double): Currency = make((amount * multiple).toLong)
  }

  type Currency <: AbstractCurrency

  def make(x: Long): Currency

  val currencyUnit: Currency
}

object US extends CurrencyZone {
  override type Currency = Dollar

  abstract class Dollar extends AbstractCurrency {
    override val designation = "USD"
  }

  override def make(cents: Long) = new Dollar {
    override val amount: Long = cents
  }

  val Cent = make(1)
  val Dollar = make(100)

  override val currencyUnit = Dollar
}

object Japan extends CurrencyZone {

  abstract class Yen extends AbstractCurrency {
    override val designation = "JPY"
  }

  type Currency = Yen

  def make(yen: Long) = new Yen {
    val amount = yen
  }

  val Yen = make(1)
  override val currencyUnit = Yen
}

Japan.Yen from US.Dollar
US.Dollar
val button = new JButton
button.addActionListener(
  (_: ActionEvent) => println("pressed")
)