object Solution {
  def mySqrt(x: Int): Int = {
    if (x < 2) {
      return x
    }

    def binaryQuery(i: Int, j: Int): Int = {
      val mid = (j - i) / 2 + i
      if (mid <= x / mid && mid + 1 > x / (mid + 1)) {
        return mid
      }
      if (x / mid < mid) {
        binaryQuery(i, mid)
      } else {
        binaryQuery(mid, j)
      }
    }

    val result = binaryQuery(0, x)
    result
  }
}

val test = 2147395601
println(math.sqrt(test))
println(Solution.mySqrt(test))
