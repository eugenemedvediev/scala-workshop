// <<script.sc>>
//> using file deep/Output.scala
{  
  println("Hello, World!")
  Output.greetMe(prefix = "Hello", name = 42)
  println(Output.extra)
  println(Output.variable)
  Output.variable = 3
  println(Output.variable)
}
