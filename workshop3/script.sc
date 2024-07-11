// script.sc
/* In Scala script we can import another Scala files with double slash and > using file
Note: that it is not comment, but instruction to use specified file in context of current script
*/
//> using file deep/StandaloneScalaObject.scala
{  
  println("Hello, from script.sc!")
  //StandaloneScalaObject.greetMe(message = "Hello")
}
