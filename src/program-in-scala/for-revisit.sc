def queens(n: Int): List[List[(Int, Int)]] = {
  def placeQueen(k: Int): List[List[(Int, Int)]] = {
    if (k == 0) {
      List(List())
    } else {
      for {
        queens <- placeQueen(k - 1)
        column <- 1 to n
        queen = (k, column)
        if queens.forall(item =>
          item._1 != queen._1 && item._2 != queen._2 && (item._1 - queen._1).abs != (item._2 - queen._2).abs)
      } yield queen :: queens
    }
  }

  placeQueen(n)
}


queens(8).length

val test: List[(Int, Int)]= List()
test.forall(item => false)
