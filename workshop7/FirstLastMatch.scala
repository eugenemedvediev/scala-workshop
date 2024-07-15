object FirstLastMatch extends App {
  val myList = List(1, 2, 3, 4)

  myList match {
    case first :: rest :: last =>
      println(s"First: $first, Last: $last, Rest: $rest")
    case _ => println("The list is too short")
  }
}
