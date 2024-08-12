package nl.rasom.scala.workshop
object MainWithConsole extends App {

  val console = new DefaultConsole

  val result = for {
    _ <- console.println("Please enter your name:")
    name <- console.readLine()
    _ <- console.println("Please enter your age:")
    age <- console.readLine()
    _ <- console.println("Please enter your city:")
    city <- console.readLine()
  } yield s"Name: $name, Age: $age, City: $city"

  result match {
    case Some(data) => println(s"User Details: $data")
    case None       => println("Some input was missing, exiting...")
  }
}
