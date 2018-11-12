case class Point(x: Int, y: Int) {
  def +(that: Point): Point = Point(this.x + that.x, this.y + that.y)
}

val a = Point(1, 1)
val b = Point(2, 2)
println(a + b)

