// <<Output.scala>>
object Output {
  val extra = "banana"
  var variable = 1
  def greetMe(prefix: String, name: Int): Unit = {
    println(s"$prefix, $extra, $name!")
  }
}
