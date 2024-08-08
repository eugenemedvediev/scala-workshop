object SimpleAppWithMain {
  def main(args: Array[String]): Unit = {

    val argsString = args.mkString(
      start = "[",
      sep = ", ",
      end = "]"
    )

    println(s"SimpleAppWithMain: $argsString")
  }
}
