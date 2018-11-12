object Solution {
  def search(nums: Array[Int], target: Int): Int = {
    val length = nums.length

    def binaryQuery(prefix: Int, suffix: Int): Int = {
      if (prefix > suffix) {
        return -1
      }
      val tempLength = suffix - prefix + 1
      val mid = tempLength / 2 + prefix
      if (nums(mid) == target) {
        return mid
      }
      if (nums(mid) < target) {
        binaryQuery(mid, suffix)
      } else {
        binaryQuery(prefix, mid - 1)
      }
    }

    binaryQuery(0, length - 1)
  }
}

var test = Array(-1, 0, 3, 5, 9, 12)
println(Solution.search(test, 2))

