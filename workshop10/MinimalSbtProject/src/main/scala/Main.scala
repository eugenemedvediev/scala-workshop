object Main extends App {
  def getInput(prompt: String): Option[String] = {
    println(prompt)
    val input = scala.io.StdIn.readLine()
    if (input.nonEmpty) Some(input) else None
  }

  val result = for {
    name <- getInput("Please enter your name:")
    age <- getInput("Please enter your age:")
    city <- getInput("Please enter your city:")
  } yield s"Name: $name, Age: $age, City: $city"

  result match {
    case Some(data) => println(s"User Details: $data")
    case None       => println("Some input was missing, exiting...")
  }
}
