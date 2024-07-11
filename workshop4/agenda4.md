### Workshop 4: Control Structures in Scala

**Objective**: By the end of this workshop, you will understand and effectively use control structures in Scala, including conditionals, loops, and pattern matching.

---

#### **Topics**:
1. Conditionals
2. Loops
3. Pattern Matching

---


### **1. Conditionals**

**a. `if-else` Statement**

- **Syntax and Usage**
  ```scala
  val x = 10

  if (x > 0) {
    println(s"$x is positive")
  } else {
    println(s"$x is non-positive")
  }
  ```

- **Multiple Conditions with `else if`**
  ```scala
  val y = -5

  if (y > 0) {
    println(s"$y is positive")
  } else if (y == 0) {
    println(s"$y is zero")
  } else {
    println(s"$y is negative")
  }
  ```

- **Ternary-like Expression**
  ```scala
  val z = 10
  val result = if (z > 0) "positive" else "non-positive"
  println(result)
  ```

**Activities:**
- **1. Basic `if-else`**
  - Manually type the code for the following example and execute it.
  - Change the value of the `a` that will execute another branch of `if-else` condition
    ```scala
    object IfElseDemo extends App {
      val a = 7
      if (a % 2 == 0) {
        println(s"$a is even")
      } else {
        println(s"$a is odd")
      }
    }
    ```
    ```sh
    $ scala-cli IfElseDemo.sc
    ```

- **2. Nested `if-else`**
  - Manually type the code for the following example and execute it.
  - Change the value of the `b` that will execute another branches of `if-else` nested conditions
     ```scala
     object NestedIfElseDemo extends App {
       val b = 15
       if (b % 3 == 0) {
         if (b % 5 == 0) {
           println(s"$b is divisible by both 3 and 5")
         } else {
           println(s"$b is divisible by 3 but not by 5")
         }
       } else {
         println(s"$b is not divisible by 3")
       }
     }
     ```
     ```sh
     $ scala-cli NestedIfElseDemo.sc
     ```

#### **2. Loops**

**a. `while` Loop**

- **Syntax and Usage**
  ```scala
  var count = 0
  while (count < 5) {
    println(s"Count is $count")
    count += 1
  }
  ```

**b. `do-while` Loop**

- **Syntax and Usage**
  ```scala
  var count2 = 0
  do {
    println(s"Count is $count2")
    count2 += 1
  } while (count2 < 5)
  ```

**c. `for` Loop**

- **Range-based Loop**
  ```scala
  for (i <- 1 to 5) {
    println(s"i is $i")
  }
  ```

- **Using `until`**
  ```scala
  for (j <- 1 until 5) {
    println(s"j is $j")
  }
  ```

- **Loop with Conditions (Guard)**
  ```scala
  for (k <- 1 to 10 if k % 2 == 0) {
    println(s"$k is even")
  }
  ```

**Activities:**
- **1. `while` Loop Example**
  - Look at the difference between `while` and `do-while` loop execution.
    ```scala
    object WhileLoopDemo extends App {
      var n = 1
      while (n <= 5) {
        println(s"n is $n")
        n += 1
      }
      do {
        println(s"n is $n")
        n += 1
      } while (n <= 5) 
    }
    ```
    ```sh
     $ scala-cli WhileLoopDemo.sc
     ```

- **2. `for` Loop Example with Range**
  - Look at the difference between `to` and `until`
    ```scala
    object ForLoopDemo extends App {
      for (i <- 1 to 5) {
        println(s"i is $i")
      }
      for (j <- 1 until 5) {
        println(s"j is $j")
      }
    }
    ```
    ```sh
    $ scala-cli ForLoopDemo.sc
    ```

- **3. `for` Loop with Condition**
    ```scala
    object ForLoopConditionDemo extends App {
      for (i <- 1 to 10 if i % 3 == 0) {
        println(s"$i is divisible by 3")
      }
    }
    ```
    ```sh
    $ scala-cli ForLoopConditionDemo.sc
    ```

#### **3. Pattern Matching**

**a. Basics of Pattern Matching**

- **Syntax and Usage**
  ```scala
  val day = "MON"

  day match {
    case "MON" => println("Monday")
    case "TUE" => println("Tuesday")
    case "WED" => println("Wednesday")
    case _ => println("Another day")
  }
  ```

**b. Pattern Matching with Types**

- **Example**
  ```scala
  def describe(x: Any): String = x match {
    case i: Int => s"Integer: $i"
    case s: String => s"String: $s"
    case d: Double => s"Double: $d"
    case _ => "Unknown type"
  }

  println(describe(5))
  println(describe("Scala"))
  println(describe(3.14))
  println(describe(true))
  ```

**Activities:**
- **1. Basic Pattern Matching Example**
  - Execute and check the results
  - Make changes to print `banana` and `Unknown fruit`
    ```scala
    object PatternMatchingDemo extends App {
      val fruit = "apple"

      fruit match {
        case "apple" => println("It's an apple")
        case "banana" => println("It's a banana")
        case _ => println("Unknown fruit")
      }
    }
    ```
    ```sh
    $ scala-cli PatternMatchingDemo.scala
    ```

- **2. Pattern Matching with Types Example**
    ```scala
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
    ```
    ```sh
    scala-cli PatternMatchingTypeDemo.scala
    ```
