import scala.io.StdIn

object IfElseDemo extends App {
  val a = StdIn.readLine("Enter number: ").toInt
  if (a % 2 == 0) {
    println(s"$a is even")
  } else {
    println(s"$a is odd")
  }
}
