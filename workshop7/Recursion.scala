import scala.annotation.tailrec

object Recursion extends App {
  val myList = List(1, 2, 3, 4)

  @tailrec
  def loop(list: List[Int], acc: List[Int] = Nil): List[Int] = list match {
    case Nil      => acc
    case x :: Nil => loop(Nil, x * 2 :: acc)
    case x :: xs  => loop(xs, x * 2 :: acc)
  }

  val result = loop(myList).reverse
  println(s"myList: $myList")
  println("processed by loop would be")
  println(s"result: $result")

  println("=" * 20)
  val alternative = myList.map(_ * 2)
  println(s"Alternative: $alternative")
}
