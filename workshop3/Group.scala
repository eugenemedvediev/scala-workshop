object Group extends App {
  println("I am main method in Group")
  // Artem
  // Lev
  // Lev.greet(friend = "Artem")
  Artem.greetBack(friend = "Lev")
  Lev.greet(greeting = "Hello", friend = "Ievgen")
  Lev.greet(greeting = "Hi", friend = "Ievgen")
}

object Lev {

  // This is expression inside object
  // println("Inside Object Lev")

  // This is the method inside object, but it will be executed only if called with .greet
  def greet(greeting: String, friend: String): Unit = {
    println(s"$greeting $friend, I am Lev")
  }

}

object Artem {
  def greetBack(friend: String): Unit = {
    println(s"Hello $friend, I am Artem. Nice to see you.")
  }
}
