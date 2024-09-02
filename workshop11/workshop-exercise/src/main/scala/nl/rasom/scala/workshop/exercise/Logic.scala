package nl.rasom.scala.workshop.exercise

import nl.rasom.scala.workshop.exercise.console.WorkshopConsole

object Logic {

  def execute(console: WorkshopConsole): Unit = {

    val result = for {
      _ <- console.println("Please enter your name:")
      name <- console.readLine()
      // TODO:
      /*Implement the rest of the interaction with the user*/
    } yield s"User Details: Name: $name" // TODO: Update the output

    // TODO: print the result to pass the test
  }

}
