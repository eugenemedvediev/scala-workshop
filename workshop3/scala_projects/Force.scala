object Force extends App {
  val g = 9.8
  println("Write your mass in kg")
  var mass = scala.io.StdIn.readInt()
  var force = g * mass
  println(s"Force of gravity pulling you is $force N")
}
