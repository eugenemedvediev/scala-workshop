# Workshop 3: Scala Syntax and Basics

### 1. Basic Syntax

**Introduction to Scala Syntax**
- Scala is a statically typed, object-oriented, and functional programming language.
- Syntax is designed to be concise and readable.
- Scala programs are typically composed of expressions rather than statements.

**Structure of a Scala script**
- A Scala script typically consists of one or more lines of code.
- Example structure:
  ```scala
  // <<script.sc>>
  println("Hello, World!")
  println("Hello, There!")
  ```
  ```scala
  // <<script.sc>>
  {
    println("Hello, World!")
    println("Hello, There!")
  }
  ```
  ```sh
  $ scala-cli script.sc
  ```
  ```scala
  // <<Output.scala>>
  object Output{
    def greet(name: String): Unit = {
      println(s"Hello, $name!")
    }
  }
  ```
  ```sh
  $ scala-cli Output.scala
  ```
- Import another script
  ```scala
  // <<script.sc>>
  //> using file Output.scala
  {
    println("Hello, World!")
    Output.greet("Scala")
  }
  ```
  ```sh
  $ scala-cli script.sc
  ```
- Self executable script
  ```scala
  #!/usr/bin/env -S scala-cli shebang
  // <<tool.sc>>
  println("I do not need scala-cli to run myself")
  ```
  ```sh
  $ scala-cli shebang tool.sc
  ```
  ```sh
  $ chmod +x tool.sc
  $ ./tool.sc
  ```
**Structure of a Scala Program**
- A Scala program typically consists of one or more objects and classes.
- The entry point of a Scala application is often an `object` with an `App` trait or a `main` method.
- Example structure:
  ```scala
  // <<MyApp.scala>>
  object MyApp {
    def main(args: Array[String]): Unit = {
      println("Hello, World!")
    }
  }
  ```
  ```sh
  $ scala-cli MyApp.scala
  ```

**Writing a Simple "Hello, World!" Program**
- The simplest form of a Scala program prints "Hello, World!" to the console.
- Using the `App` trait, which provides a main method:
  ```scala
  // <<MyApp.scala>>
  object MyApp extends App {
    println("Hello, World!")
  }
  ```
  ```sh
  $ scala-cli MyApp.scala
  ```
  - **Explanation:**
    - `object MyApp` defines a singleton object named `MyApp`.
    - `extends App` makes `MyApp` an application with a predefined `main` method.
    - `println("Hello, World!")` is a method call that prints "Hello, World!" to the console.

**Explanation of the `object` and `App` Trait**

- **object**:
  - Defines a singleton instance.
  - Useful for defining utility methods or single-entry points.
  - No need to create an instance to access its members.
  - Example:
    ```scala
    object MyObject {
      def greet(name: String): Unit = {
        println(s"Hello, $name!")
      }
    }
    
    MyObject.greet("Alice")
    ```
    - `MyObject` is created automatically and can be used directly.

- **App Trait**:
  - Simplifies the creation of a main application.
  - Automatically provides a `main` method.
  - Code inside the object body is executed when the program runs.
  - Example without `App`:
    ```scala
    object HelloWorld {
      def main(args: Array[String]): Unit = {
        println("Hello, World!")
      }
    }
    ```
  - Example with `App`:
    ```scala
    object HelloWorld extends App {
      println("Hello, World!")
    }
    ```
    - Using `App` reduces boilerplate code, making the program simpler and more concise.

### 2. Variables

**Variable Declaration with `val` and `var`**
- **`val` (Immutable Variable)**
  - Declares a value that cannot be changed once assigned.
  - Equivalent to a final variable in Java.
  - Example:
    ```scala
    val immutableValue = 10
    // immutableValue = 20 // This will cause a compilation error
    ```
- **`var` (Mutable Variable)**
  - Declares a variable whose value can be changed.
  - Should be used sparingly to encourage immutability.
  - Example:
    ```scala
    var mutableValue = 10
    mutableValue = 20 // This is allowed
    ```

**Differences Between Mutable (`var`) and Immutable (`val`) Variables**
- `val` ensures that the reference to the value cannot be reassigned, promoting safer and more predictable code.
- `var` allows reassignment, which can lead to more complex and error-prone code.

**Type Inference and Explicit Type Declaration**
- **Type Inference**
  - Scala can automatically infer the type of a variable based on the assigned value.
  - Example:
    ```scala
    val inferredInt = 42  // Type inferred as Int
    val inferredString = "Scala"  // Type inferred as String
    ```
- **Explicit Type Declaration**
  - The type can also be explicitly specified.
  - Example:
    ```scala
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
    object VariablesDemo extends App {
      val immutableValue: Int = 10
      var mutableValue: Int = 20
      println(s"Immutable Value: $immutableValue")
      println(s"Mutable Value: $mutableValue")
      mutableValue += 10
      println(s"Updated Mutable Value: $mutableValue")
    }
    ```
    - **Instructions:**
      - Create a new Scala file named `VariablesDemo.scala`.
      - Write the script and observe the output.
      - Modify `mutableValue` and print its updated value.
      - Run the script using `scala-cli`:
        ```sh
        scala-cli VariablesDemo.scala
        ```

2. **Type Inference and Explicit Types**
    ```scala
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
    - **Instructions:**
      - Create a new Scala file named `TypeInferenceDemo.scala`.
      - Write the script and observe the output.
      - Discuss the advantages of type inference in Scala.
      - Run the script using `scala-cli`:
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

**Activities:**
1. **Basic Operations**
    ```scala
    object BasicOperations extends App {
      val x = 10
      val y = 5
      println(s"Addition: ${x + y}")
      println(s"Subtraction: ${x - y}")
      println(s"Multiplication: ${x * y}")
      println(s"Division: ${x / y}")
      println(s"Modulo: ${x % y}")
      println(s"Equal: ${x == y}")
      println(s"Not Equal: ${x != y}")
      println(s"Greater than: ${x > y}")
      println(s"Less than: ${x < y}")
      println(s"Logical AND: ${x > 0 && y > 0}")
      println(s"Logical OR: ${x > 0 || y < 0}")
      println(s"Logical NOT: ${!(x > 0)}")
    }
    ```
    - **Instructions:**
      - Create a new Scala file named `BasicOperations.scala`.
      - Write the script and run it.
      - Experiment with different values for `x` and `y` to observe different outcomes.
      - Run the script using `scala-cli`:
        ```sh
        scala-cli BasicOperations.scala
        ```

2. **Assignment Operations**
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
    - **Instructions:**
      - Create a new Scala file named `AssignmentOperations.scala`.
      - Write the script and run it.
      - Experiment with different assignment operations and observe the outcomes.
      - Run the script using `scala-cli`:
        ```sh
        scala-cli AssignmentOperations.scala
        ```

### Additional Resources:
- **Scala Documentation:** [Scala Basics](https://docs.scala-lang.org/tour/basics.html)
- **Scala REPL:** Use the Scala REPL for interactive exploration of syntax and immediate feedback.
