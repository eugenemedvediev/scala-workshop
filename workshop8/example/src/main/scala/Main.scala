/* Option 1 */
object Main {
  def main(args: Array[String]): Unit = {
    val logicRunResult = Logic.run(
      args.mkString(", ")
    )
    println(s"Main: Logic Run Result: $logicRunResult")
  }
}

/* Option 2 */
// @main def scala3main(age: Int, name: String): Unit =
//   val logicRunResult = Logic.run(s"age=$age, name=$name")
//   println(s"scala3main: Logic Run Result: $logicRunResult")
