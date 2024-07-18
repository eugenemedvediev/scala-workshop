object TymurTrait extends App {
  sealed trait Shape
  sealed trait Angles
  sealed trait OddAngles extends Angles
  sealed trait EvenAngles extends Angles

  case class Circle(radius: Double) extends Shape
  case class Triangle(name: String) extends Shape with OddAngles
  case class Rectangle(width: Double, height: Double)
      extends Shape
      with EvenAngles
  case class Pentagon(name: String) extends Shape with OddAngles

  def describeShape(shape: Shape): String = shape match
    case Circle(radius)           => s"A circle with radius $radius"
    case Triangle(name)           => s"A tri with radius $name"
    case Rectangle(width, height) => s"A rect with radius ${width + height}"
    case Pentagon(name)           => s"A pent with radius $name"

//   match {
//     case Circle(radius) => s"A circle with radius $radius"
//     case Rectangle(width, height) =>
//       s"A rectangle with width $width and height $height"
//   }

  val myShape: Shape = Circle(5.0)
  println(describeShape(myShape)) // Output: A circle with radius 5.0

  val withAngles: Angles = Triangle(name = "Anton")
  
  def processOddAngles(x: OddAngles): Unit =
    x match
      case Triangle(name) => println(s"Triangle $name")
      case Pentagon(name) => println("Pentagon")

  withAngles match {
    case x: OddAngles => {
      println("OddAngles")
      processOddAngles(x)
    }
    case y: EvenAngles => {
      println("Even")
      y match
        case Rectangle(width, height) => println("Rectangle")
    }

  }

   val anton2Hidden: OddAngles = Pentagon(name = "Anton2") 
   anton2Hidden match
    case x: OddAngles => x match
        case Triangle(name) => 
        case Pentagon(name) =>
    
        //  x match
        // case Triangle(name) => println("triangle")
        // case Pentagon(name) => println("pentagon")

    
    
   
   
}
