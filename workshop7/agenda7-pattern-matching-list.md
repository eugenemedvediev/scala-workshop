### Workshop 7: Pattern Matching for Collections

---

### **Topics**:
1. Basic List Pattern Matching
2. Matching List Elements
3. Matching List Length
4. Extracting Elements from Lists

### **Activities**:
- Writing Scala scripts to perform pattern matching on lists.
- Exercises and hands-on coding.

---

### **1. Basic List Pattern Matching**

**a. Matching Empty and Non-Empty Lists**

- **Syntax and Usage**
  ```scala
  val list = List(1, 2, 3)

  list match {
    case Nil => println("The list is empty")
    case _ => println("The list is not empty")
  }
  ```

**b. Matching Specific Lists**

- **Example**
  ```scala
  val list = List(1, 2, 3)

  list match {
    case List(1, 2, 3) => println("The list is exactly List(1, 2, 3)")
    case _ => println("The list does not match")
  }
  ```

**Activities:**
1. **Matching an Empty List**
   ```scala
   object EmptyListMatch extends App {
     val emptyList = List()

     emptyList match {
       case Nil => println("The list is empty")
       case _ => println("The list is not empty")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `EmptyListMatch.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli EmptyListMatch.scala
       ```

2. **Matching a Specific List**
   ```scala
   object SpecificListMatch extends App {
     val myList = List(1, 2, 3)

     myList match {
       case List(1, 2, 3) => println("The list is exactly List(1, 2, 3)")
       case _ => println("The list does not match")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `SpecificListMatch.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli SpecificListMatch.scala
       ```

### **2. Matching List Elements**

**a. Matching Head and Tail**

- **Syntax and Usage**
  ```scala
  val list = List(1, 2, 3)

  list match {
    case head :: tail => println(s"Head: $head, Tail: $tail")
    case Nil => println("The list is empty")
  }
  ```
- Alternative Syntax and Best Practice
  ```scala
  val list = List(1, 2, 3)

  list match {
    case x :: xs => println(s"Head: $x, Tail: $xs")
    case Nil => println("The list is empty")
  }
  ```

**b. Extracting Multiple Elements**

- **Example**
  ```scala
  val list = List(1, 2, 3)

  list match {
    case first :: second :: rest => println(s"First: $first, Second: $second, Rest: $rest")
    case _ => println("The list does not have enough elements")
  }
  ```

**Activities:**
1. **Matching Head and Tail**
   ```scala
   object HeadTailMatch extends App {
     val myList = List(1, 2, 3)

     myList match {
       case head :: tail => println(s"Head: $head, Tail: $tail")
       case Nil => println("The list is empty")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `HeadTailMatch.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli HeadTailMatch.scala
       ```

2. **Extracting Multiple Elements**
   ```scala
   object MultiElementMatch extends App {
     val myList = List(1, 2, 3, 4)

     myList match {
       case first :: second :: rest => println(s"First: $first, Second: $second, Rest: $rest")
       case _ => println("The list does not have enough elements")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `MultiElementMatch.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli MultiElementMatch.scala
       ```

### **3. Matching List Length**

**a. Matching Lists of Specific Lengths**

- **Example**
  ```scala
  val list = List(1, 2, 3)

  list match {
    case List(a, b, c) => println(s"List has three elements: $a, $b, $c")
    case _ => println("List does not have exactly three elements")
  }
  ```

**Activities:**
1. **Matching List with Three Elements**
   ```scala
   object ThreeElementMatch extends App {
     val myList = List(1, 2, 3)

     myList match {
       case List(a, b, c) => println(s"List has three elements: $a, $b, $c")
       case _ => println("List does not have exactly three elements")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `ThreeElementMatch.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli ThreeElementMatch.scala
       ```

### **4. Extracting Elements from Lists**

**a. Extracting First and Last Elements**

- **Example**
  ```scala
  val list = List(1, 2, 3, 4)

  list match {
    case first :: rest :+ last => println(s"First: $first, Last: $last, Rest: $rest")
    case _ => println("The list is too short")
  }
  ```

**Activities:**
1. **Extracting First and Last Elements**
   ```scala
   object FirstLastMatch extends App {
     val myList = List(1, 2, 3, 4)

     myList match {
       case first :: rest :+ last => println(s"First: $first, Last: $last, Rest: $rest")
       case _ => println("The list is too short")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `FirstLastMatch.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli FirstLastMatch.scala
       ```

### **5. Matching list with logic. Preparation for recursion**

**a. Matching list with logic**

- **Example**
  ```scala
  val list = List(1, 2, 3, 4)

  list match {
    case Nil => println("List is empty")
    case x :: Nil => println("List has 1 element")
    case x :: xs => println("List has more than 1 element")
  }
  ```

**Activities:**
1. **Simple recursion**
   ```scala
   object Recursion extends App {
     val myList = List(1, 2, 3, 4)

     def loop(list: List[Int], acc: List[Int] = Nil): List[Int] = list match {
       case Nil      => acc
       case x :: Nil => loop(Nil, x * 2 :: acc)
       case x :: xs  => loop(xs, x * 2 :: acc)
     }

     val result = loop(myList).reverse
     println(s"myList: $myList")
     println("processed by loop would be")
     println(s"result: $result")

     println("=" * 20)
     val alternative = myList.map(_ * 2)
     println(s"Alternative: $alternative")
   }
  ```
   - **Instructions:**
     - Create a Scala file named `Recursion.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli Recursion.scala
       ```
