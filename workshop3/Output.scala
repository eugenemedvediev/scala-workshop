object Output {
  private val extra = "banana"
  def greet(name: String): Unit = {
    println(s"Hello, and $extra,  $name!")
  }
}
