package recfun

import scala.util.parsing.json.JSONArray

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    val isBalanced = balance("(()()()())".toList)
    println("Is it balanced? => " + isBalanced)
    println("There are " + countChange(6, List(1, 2)) + "ways! ")
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    * (if (zero? x) max (/ 1 x))
    */
  def balance(chars: List[Char]): Boolean = {

    def getStatus(chars: List[Char], count: Int): Int = {
      def getNewCount = chars.head match {
        case '(' => count + 1
        case ')' => count - 1
        case _ => count
      }

      if (chars.length == 0 || count < 0)
        count
      else
        getStatus(chars.tail, getNewCount)
    }

    getStatus(chars, 0) == 0
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.length > 0) {
      val balance = (money - coins.head)
      val count: Int =
        if (money == 0 || balance < 0)
          0
        else if (balance == 0)
          1
        else
          countChange(balance, coins)

      if (coins.length > 1 && money > 0)
        count + countChange(money, coins.tail)
      else count
    } else 0
  }
}
