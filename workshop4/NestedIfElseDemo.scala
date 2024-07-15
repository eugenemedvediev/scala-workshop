import scala.io.StdIn

object NestedIfElseDemo extends App {
  val b = StdIn.readLine("Enter number: ").toInt
  if (b % 3 == 0) {
    if (b % 5 == 0) {
      println(s"$b is divisible by both 3 and 5")
    } else {
      println(s"$b is divisible by 3 but not by 5")
    }
  } else {
    println(s"$b is not divisible by 3")
  }
}
