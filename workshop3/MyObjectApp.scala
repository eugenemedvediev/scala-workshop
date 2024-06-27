object MyObjectApp extends App {

  object MyObject {
    def greet(name: String): Unit = {
      println(s"Hello, $name!")
    }
  }

  MyObject.greet("Alice")
}
