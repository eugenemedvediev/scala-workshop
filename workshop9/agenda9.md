### Workshop 9: Options and For Comprehension in Scala

**Objective**: By the end of this workshop, you will understand how to work with `Option` in Scala, the difference between `map` and `flatMap`, and how to use `for-comprehension` as an elegant alternative to chaining `map` and `flatMap`.

---

### **Topics**:
1. Introduction to `Option` in Scala
2. Working with `map` and `flatMap`
3. Using `for-comprehension`
4. Comparison: `map`/`flatMap` vs. `for-comprehension`
5. Handling `None` and Default Values

### **Activities**:
- Writing Scala scripts to practice using `Option`, `map`, `flatMap`, and `for-comprehension`.
- Exercises to explore the differences and benefits of using `for-comprehension`.

---

### **1. Introduction to `Option` in Scala**

**a. What is `Option`?**

- **Definition**: `Option` is a container type that represents a value that might be present (`Some`) or absent (`None`).
- **Syntax**:
  ```scala
  val someValue: Option[Int] = Some(42)
  val noValue: Option[Int] = None
  ```
  Some(value).map(v => v + 1)
  +-------------------------------------------+
  |                                           |
  |                value                      |
  |                                           |
  +-------------------------------------------+

  +-------------------------------------------+
  |                                           |
  |                value + 1                  |
  |                                           |
  +-------------------------------------------+

  Some(value).flatMap(v => Some(v + 1))
  +-------------------------------------------+
  |                                           |
  |                value                      |
  |                                           |
  +-------------------------------------------+
  
  +-------------------------------------------+
  |                                           |
  |   +-----------------------------------+   |
  |   |                                   |   |
  |   |            value + 1              |   |
  |   |                                   |   |
  |   +-----------------------------------+   |
  |                                           |
  |                                           |
  |                                           |
  +-------------------------------------------+
 
  +-------------------------------------------+
  |                                           |
  |                value + 1                  |
  |                                           |
  +-------------------------------------------+

**b. Basic Operations**

- **Checking for value presence**:
  ```scala
  someValue.isDefined // true
  noValue.isDefined   // false
  ```

- **Getting the value safely**:
  ```scala
  someValue.getOrElse(0) // 42
  noValue.getOrElse(0)   // 0
  ```

**Activities:**
1. **Working with `Option`**
   ```scala
   val maybeNumber: Option[Int] = Some(10)
   val maybeNothing: Option[Int] = None

   println(maybeNumber.getOrElse(0))  // Output: 10
   println(maybeNothing.getOrElse(0)) // Output: 0
   ```
   - **Instructions:**
     - Create a Scala file named `OptionDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli OptionDemo.scala
       ```

---

### **2. Working with `map` and `flatMap`**

**a. `map` with `Option`**

- **Purpose**: Apply a function to the value inside `Some` if it exists; otherwise, return `None`.
- **Example**:
  ```scala
  val number: Option[Int] = Some(10)

  val result = number.map(_ * 2)
  println(result) // Output: Some(20)
  ```

**b. `flatMap` with `Option`**

- **Purpose**: Similar to `map`, but the function returns an `Option`, flattening nested `Option`s.
- **Example**:
  ```scala
  val number: Option[Int] = Some(10)

  val result = number.flatMap(n => Some(n * 2))
  println(result) // Output: Some(20)
  ```

**Activities:**
1. **Using `map` and `flatMap`**
   ```scala
   val number: Option[Int] = Some(5)

   val mapResult = number.map(_ + 10)
   val flatMapResult = number.flatMap(n => Some(n * 2))

   println(mapResult)    // Output: Some(15)
   println(flatMapResult) // Output: Some(10)
   ```
   - **Instructions:**
     - Create a Scala file named `MapFlatMapDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli MapFlatMapDemo.scala
       ```

---

### **3. Using `for-comprehension`**

**a. Introduction**

- **Purpose**: `for-comprehension` is a syntactic sugar in Scala that simplifies the chaining of `map` and `flatMap` operations, especially when dealing with multiple `Option`s.

**b. Example**

- **Example using `map` and `flatMap`**:
  ```scala
  val opt1: Option[Int] = Some(10)
  val opt2: Option[Int] = Some(20)

  val result = opt1.flatMap(a => opt2.map(b => a + b))
  println(result) // Output: Some(30)
  ```

- **Same Example using `for-comprehension`**:
  ```scala
  val result = for {
    a <- opt1
    b <- opt2
  } yield a + b

  println(result) // Output: Some(30)
  ```

**Activities:**
1. **Using `for-comprehension`**
   ```scala
   val opt1: Option[Int] = Some(3)
   val opt2: Option[Int] = Some(4)
   val opt3: Option[Int] = Some(5)

   val result = for {
     a <- opt1
     b <- opt2
     c <- opt3
   } yield a * b * c

   println(result) // Output: Some(60)
   ```
   - **Instructions:**
     - Create a Scala file named `ForComprehensionDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli ForComprehensionDemo.scala
       ```

---

### **4. Comparison: `map`/`flatMap` vs. `for-comprehension`**

**a. Readability and Simplicity**

- **Chaining `map` and `flatMap`**:
  ```scala
  val opt1: Option[Int] = Some(10)
  val opt2: Option[Int] = Some(20)
  val opt3: Option[Int] = Some(30)

  val result = opt1.flatMap(a =>
    opt2.flatMap(b =>
      opt3.map(c => a + b + c)
    )
  )

  println(result) // Output: Some(60)
  ```

- **Using `for-comprehension`**:
  ```scala
  val result = for {
    a <- opt1
    b <- opt2
    c <- opt3
  } yield a + b + c

  println(result) // Output: Some(60)
  ```

**b. Nesting and Complexity**

- **Avoiding deeply nested code**: `for-comprehension` flattens the nested structure, making the code more readable and maintainable.

**Activities:**
1. **Comparison Exercise**
   - Rewrite a nested `map`/`flatMap` chain using `for-comprehension` to see the difference in readability and simplicity.

---

### **5. Handling `None` and Default Values**

**a. Handling `None`**

- **Using `getOrElse`**: Safely extract a value or provide a default.
  ```scala
  val noValue: Option[Int] = None
  println(noValue.getOrElse(100)) // Output: 100
  ```

**b. Combining with `for-comprehension`**

- **Example**:
  ```scala
  val opt1: Option[Int] = Some(10)
  val opt2: Option[Int] = None

  val result = for {
    a <- opt1
    b <- opt2
  } yield a + b

  println(result.getOrElse(0)) // Output: 0
  ```

**Activities:**
1. **Handling `None` Example**
   ```scala
   val opt1: Option[Int] = Some(10)
   val opt2: Option[Int] = None

   val result = for {
     a <- opt1
     b <- opt2
   } yield a * b

   println(result.getOrElse(1)) // Output: 1
   ```
   - **Instructions:**
     - Create a Scala file named `HandleNoneDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli HandleNoneDemo.scala
       ```

---
