# Workshop 3: Scala Syntax and Basics

### 1. Basic Syntax

**Introduction to Scala Syntax**
- Scala is a statically typed, object-oriented, and functional programming language.
- Syntax is designed to be concise and readable.
- Scala programs are typically composed of expressions rather than statements.

**Comments**
- Comments in Scala have 2 kinds:
  - Documentation (multiline) `DocumentationComment.sc`:
```scala
/* Slash and star in the beginning and star slash in the end represents multiline comment*/
/* This multiline comment also ignored
by compiler*/
```
  - One line comments
```scala
// Double slash represent one line comment. All the code after double slash will be treated as one line comment
```

**Structure of a Scala script**
- A Scala script typically consists of one or more lines of code.
- Example structure:
```scala
/* In all following examples
the first comment line will represent the name of the file
where this code should be placed.
For example: */
// script.sc
/* println method prints the content inside brackets () to the console */
println("Hello, World!")
println("Hello, There!")
```
```scala
// script.sc
{
  println("Hello, World!")
  println("Hello, There!")
}
```
```sh
$ scala-cli script.sc
```
- Import another script
```scala
// deep/Output.scala
/* You need to greate folder called 'deep' and put 'Output.scala' file there */
object Output {
  def greetMe(message: String): Unit = {
    println(s"$message, from deep/Output.scala file!")
  }
}
```
```sh
$ scala-cli deep/Output.scala
```
  You will see an error 'No main class found'. In the following examples we will
  see how to create scala file with main execution point.

```scala
// script.sc
/* In Scala script we can import another Scala files with double slash and > using file
Note: that it is not comment, but instruction to use specified file in context of current script
*/
//> using file deep/Output.scala
{  
  println("Hello, from script.sc!")
  Output.greetMe(message = "Hello")
}
```
```sh
$ scala-cli script.sc
```
- Self executable script
```scala
#!/usr/bin/env -S scala-cli shebang
// tool.sc
/* Important note: In the shebang scripts the first line should start with #!/
symbols, not comments, else script should not be recognized as shebang. */
println("I do not need scala-cli to run myself")
```
```sh
$ scala-cli shebang tool.sc
```
```sh
$ chmod +x tool.sc
$ ./tool.sc
```
  As you can see now we can run our script without calling it via scala-cli

**Structure of a Scala Program**
- A Scala program typically consists of one or more objects and classes.
- The entry point of a Scala application is often an `object` with an `App` trait or a `main` method.
- Example structure:
```scala
// ObjectWithMainMethod.scala
object ObjectWithMainMethod {
  def main(args: Array[String]): Unit = {
    println("Hello, Scala!")
  }
}
```
```sh
$ scala-cli ObjectWithMainMethod.scala
```

**Writing a Simple "Hello, Scala!" Program**
- The simplest form of a Scala program prints "Hello, World!" to the console.
- Using the `App` trait, which provides a main method:
```scala
// ObjectWithAppTrait.scala
object ObjectWithAppTrait extends App{
  println("Hello, Scala!")
}
```
```sh
$ scala-cli ObjectWithAppTrait.scala
```
  - **Explanation:**
    - `object ObjectWithAppTrait` defines a singleton object named `ObjectWithAppTrait`.
    - `extends App` makes `ObjectWithAppTrait` an application with a predefined `main` method.
    - `println("Hello, Scala!")` is a method call that prints "Hello, World!" to the console.

**Explanation of the `object` and `App` Trait**

- **object**:
  - Defines a singleton instance.
  - Useful for defining utility methods or single-entry points.
  - No need to create an instance to access its members.
  - Example:
```scala
// <<SingletonObjectApp.scala>>
object SingletonObjectApp extends App {

  object SingletonObject {
    def greet(name: String): Unit = {
      println(s"Hello, $name!")
    }
  }

  SingletonObject.greet("Scala")
}
```
 - `SingletonObject` is created automatically and can be used directly.


### 2. Variables

**Variable Declaration with `val` and `var`**
- **`val` (Immutable Variable)**
  - Declares a value that cannot be changed once assigned.
  - Equivalent to a final variable in Java.
  - Example:
```scala
// <<Val.sc>>
val immutableValue = 10
// immutableValue = 20 // This will cause a compilation error
```
- **`var` (Mutable Variable)**
  - Declares a variable whose value can be changed.
  - Should be used sparingly to encourage immutability.
  - Example:
```scala
// <<Var.sc>>
var mutableValue = 10
println(s"mutableValue before: $mutableValue")
mutableValue = 20 // This is allowed
println(s"mutableValue after: $mutableValue")
```

**Differences Between Mutable (`var`) and Immutable (`val`) Variables**
- `val` ensures that the reference to the value cannot be reassigned, promoting safer and more predictable code.
- `var` allows reassignment, which can lead to more complex and error-prone code.

**Type Inference and Explicit Type Declaration**
- **Type Inference**
  - Scala can automatically infer the type of a variable based on the assigned value.
  - Example:
```scala
// <<Types.sc>>
val inferredInt = 42  // Type inferred as Int
val inferredString = "Scala"  // Type inferred as String
```
- **Explicit Type Declaration**
  - The type can also be explicitly specified.
  - Example:
```scala
// <<Types.sc>>
val explicitInt: Int = 42
val explicitString: String = "Scala"
```

**Basic Data Types**
- **Common Data Types**
  - `Int`: Integer values
  - `Double`: Floating-point numbers
  - `String`: Sequence of characters
  - `Boolean`: True or false values
  - Example:
```scala
val anInt: Int = 10
val aDouble: Double = 3.14
val aString: String = "Hello"
val aBoolean: Boolean = true
```

**Activities:**
1. **Variable Declaration and Usage**
```scala
// <<VariablesDemo.scala>>
object VariablesDemo extends App {
  val immutableValue: Int = 10
  var mutableValue: Int = 20
  println(s"Immutable Value: $immutableValue")
  println(s"Mutable Value: $mutableValue")
  mutableValue += 10
  println(s"Updated Mutable Value: $mutableValue")
}
```
```sh
scala-cli VariablesDemo.scala
```

2. **Type Inference and Explicit Types**
```scala
// <<TypeInferenceDemo.scala>>
object TypeInferenceDemo extends App {
  val inferredInt = 42
  val inferredDouble = 3.14
  val inferredString = "Scala"
  val explicitInt: Int = 42
  val explicitDouble: Double = 3.14
  val explicitString: String = "Scala"
  println(s"Inferred Int: $inferredInt")
  println(s"Inferred Double: $inferredDouble")
  println(s"Inferred String: $inferredString")
  println(s"Explicit Int: $explicitInt")
  println(s"Explicit Double: $explicitDouble")
  println(s"Explicit String: $explicitString")
}
```
```sh
scala-cli TypeInferenceDemo.scala
```

### 3. Operators

**Arithmetic Operators**
- Perform basic arithmetic operations.
- Examples:
```scala
object ArithmeticOperations extends App {
  val x = 10
  val y = 5
  println(s"Addition: ${x + y}")
  println(s"Subtraction: ${x - y}")
  println(s"Multiplication: ${x * y}")
  println(s"Division: ${x / y}")
  println(s"Modulo: ${x % y}")
}
```

**Comparison Operators**
- Compare two values.
- Examples:
```scala
object ComparisonOperations extends App {
  val x = 10
  val y = 5
  println(s"Equal: ${x == y}")
  println(s"Not Equal: ${x != y}")
  println(s"Greater than: ${x > y}")
  println(s"Less than: ${x < y}")
  println(s"Greater than or equal: ${x >= y}")
  println(s"Less than or equal: ${x <= y}")
}
```

**Logical Operators**
- Combine multiple boolean expressions.
- Examples:
```scala
object LogicalOperations extends App {
  val x = 10
  val y = 5
  println(s"Logical AND: ${x > 0 && y > 0}")
  println(s"Logical OR: ${x > 0 || y < 0}")
  println(s"Logical NOT: ${!(x > 0)}")
}
```

**Assignment Operators and Compound Assignment**
- Assign values to variables.
- Compound assignment combines an operator with assignment.
- Examples:
```scala
object AssignmentOperations extends App {
  var x = 10
  x += 5  // Equivalent to x = x + 5
  println(s"Addition Assignment: $x")
  x -= 3  // Equivalent to x = x - 3
  println(s"Subtraction Assignment: $x")
  x *= 2  // Equivalent to x = x * 2
  println(s"Multiplication Assignment: $x")
  x /= 4  // Equivalent to x = x / 4
  println(s"Division Assignment: $x")
}
```
