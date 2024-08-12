object EmptyListMatch extends App {
  val emptyList = List(1)

  emptyList match {
    case Nil => println("The list is empty")
    case _   => println("The list is not empty")
  }
}
