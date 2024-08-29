package nl.rasom.scala.workshop.extracted

import nl.rasom.scala.workshop.DefaultConsole

class MainWithConsoleAndExtractedLogic extends App {

  val console = new DefaultConsole
  Logic.execute(console)
}
