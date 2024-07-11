// Val.sc
// val banana = 10
// val apple = 20
// // banana = 20 // This will cause a compilation error
// println(s"val = $banana")
// // println(s"ananas = $pineapple")
object Parent { 
  val child1 = "child1"
  val blockValue = { 
    val child2 = "child2"
    val child1 = "child new"
    println(s"child2 = $child2")
    println(s"child new = $child1")
    println(s"child1Parent = ${ Parent.child1 }")
    child2
  }
  println(s"child in parent = $child1")
  println(s"Value from block $blockValue")
}
Parent
// { 
//   val banana = 30
//   println(s"inner block $banana")
//   println(s"inner block $apple")
//   val pineapple = 40
// }
