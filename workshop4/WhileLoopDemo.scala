
object WhileLoopDemo extends App {
  var n = 1

  do {
    n += 1
    println(s"do while: n is $n")
  } while (n <= 5) 

  n = 1
  while (n <= 5) {
    println(s"while: n is $n")
    n += 1
  }

}
