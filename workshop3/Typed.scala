import scala.runtime.stdLibPatches.language.experimental.namedTypeArguments
// TypeInferenceDemo.scala
object TypeInferenceDemo extends App {

  // val inferredInt = 42
  // val inferredLong = 42L
  // val inferredDouble = 3.14
  // val inferredDoubleWithD = 3.14d
  // val inferredFloat = 3.14f
  // val inferredString = "Scala"
  // val explicitInt: Int = 42
  // val explicitDouble: Double = 3.14
  // val three = 3.0
  // val explicitString: String = "Scala"

  // println(s"Inferred Int: $inferredInt")
  // println(s"Inferred Long: $inferredLong")
  // println(s"Inferred Double: $inferredDouble")
  // println(s"Inferred Double With D: $inferredDoubleWithD")
  // println(s"Inferred Float: $inferredFloat")
  // println(s"Inferred String: $inferredString")
  // println(s"Explicit Int: $explicitInt")
  // println(s"Explicit Double: $explicitDouble")
  // println(s"Explicit String: $explicitString")
  // println(s" ${15 % 5}")
  // val one = "+-"

  // println(s"res ${one * 10}")
  // println("#" * 100)
  // println(s"res ${one * 10}")

  // class Tymur {
  //   val age: String;
  //   val name: Int;
  //   def

  //   def getName(): String = name
  //   def getAge(): Int = age
  //   def setName(name: String) = this.name = name
  //   def setAge(age: Int) = this.age = age

  // }

  // new Tymur().getAge()

  case class Student(
      name: String,
      age: Int = 40,
      scores: List[Int] = List.empty
  ) {
    def selfPresent() = println(s"My name is $name")
  }

  val artem = Student(name = "Artem", age = 13, scores = List(5, 5))
  val tymur = Student(name = "Tymur", age = 16, scores = List(5, 4))

  println(s"Better Scores: ${artem.scores.sum > tymur.scores.sum}")
  artem.selfPresent()
  println(s" artem ${artem.age} ${artem.name} scores: ${artem.scores} ")
}
