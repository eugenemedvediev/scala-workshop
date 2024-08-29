package nl.rasom.scala.workshop.extracted
import nl.rasom.scala.workshop.CustomConsole

object Logic {

  def execute(console: CustomConsole): Unit = {

    val result = for {
      _ <- console.println("Please enter your name:")
      name <- console.readLine()
      _ <- console.println("Please enter your age:")
      age <- console.readLine()
      _ <- console.println("Please enter your city:")
      city <- console.readLine()
      _ <- console.println("Please enter your street:")
      street <- console.readLine()
    } yield s"User Details: Name: $name, Age: $age, City: $city, Street: $street"

    result.map(console.println)
  }

}
