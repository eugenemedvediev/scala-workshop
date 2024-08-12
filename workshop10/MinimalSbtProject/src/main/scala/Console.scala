package nl.rasom.scala.workshop

trait CustomConsole {
  def println(message: String): Option[Unit]
  def readLine(): Option[String]
}

class DefaultConsole extends CustomConsole {

  def println(message: String): Option[Unit] = Some(
    Console.out.println(message)
  )
  def readLine(): Option[String] = Some(Console.in.readLine())
}
