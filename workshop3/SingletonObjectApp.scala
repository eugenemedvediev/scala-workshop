// <<SingletonObjectApp.scala>>
object SingletonObjectApp extends App {

  object SingletonObject {
    def greet(name: String): Unit = {
      println(s"Hello, $name!")
    }
  }

  SingletonObject.greet("Scala")
}
