object Ievgen {

  def main(args: Array[String]): Unit = {
    println(s"Inside main: $tymur")
    println(s"Arguments: ${args.map(_.toInt).toList(2)}")
  }

  val tymur = "Tymur"
  val character = '%'
  println(character)
  println(s"Name: $tymur")
  println("After")
}
