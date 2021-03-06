package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def aux(chars: List[Char], bracketOpens: Int): Boolean = {
      if (chars.isEmpty) {
        true
      } else {
        val h = chars.head
        val n =
          if (h == '(') bracketOpens + 1
          else if (h == ')') bracketOpens - 1
          else bracketOpens
        if (n >= 0) aux(chars.tail, n)
        else false
      }
    }

    aux(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (coins.isEmpty || money < 0) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}

