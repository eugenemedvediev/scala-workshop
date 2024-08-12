object HeadTailMatch extends App {
  val myList = List(1)

  myList match {
    case head :: second :: tail => println(s"Head: $head, Tail: $tail")
    case head :: tail           => println(s"list with one element $head")
    case Nil                    => println("The list is empty")
  }
}
