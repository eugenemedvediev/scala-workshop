package nl.rasom.scala.workshop
object ConsoleLogic {

  def execute(console: CustomConsole): Unit = {

    val result = for {
      _ <- console.println("Please enter your name:")
      name <- console.readLine()
      _ <- console.println("Please enter your age:")
      age <- console.readLine()
      _ <- console.println("Please enter your city:")
      city <- console.readLine()
    } yield s"Name: $name, Age: $age, City: $city"

    result match {
      case Some(data) => console.println(s"User Details: $data")
      case None       => console.println("Some input was missing, exiting...")
    }
  }

}
