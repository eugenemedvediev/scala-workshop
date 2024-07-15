object PatternMatchingTypeDemo extends App {

  def typeMatch(x: Any): String = x match {
    case i: Int => s"Int: $i"
    case s: String => s"String: $s"
    case d: Double => s"Double: $d"
    case _: Float => "It is Float"
    case _ => "Unknown type"
  }

  println(typeMatch(42))
  println(typeMatch("Hello"))
  println(typeMatch(3.14))
  println(typeMatch(3.14F))
  println(typeMatch(true))
}