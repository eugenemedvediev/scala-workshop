import scala.io.StdIn
object PatternMatchingDemo extends App {

  val fruit = StdIn.readLine("fruit: ")
  fruit match {
    case "apple" => println("It's an apple")
    case "banana" => println("It's a banana")
    case _ => println("Unknown fruit")
  }
}