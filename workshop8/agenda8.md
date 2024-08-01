### Workshop 8: Project structure

---

### **Topics**:
1. Simple script/App
2. Simple project 
3. Project with sbt

---

### **1. Simple script/App**

**Activities:**
1. **Matching an Empty List**
   ```scala
   println("Simple script")
   ```
   - **Instructions:**
     - Create a Scala file named `SimpleScript.sc`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli SimpleScript.sc
       ```

2. **Matching a Specific List**
   ```scala
   object SimpleApp extends App {
     println(s"Simple App $args")
   ```
   - **Instructions:**
     - Create a Scala file named `SimpleApp.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli SimpleApp.scala
       ```

### **2. Simple project**

**a. .project file**

- **Syntax and Usage**
  ```scala
  val list = List(1, 2, 3)

  list match {
    case Nil => println("The list is empty")
    case _ => println("The list is not empty")
  }
  ```

**b. Run Scala App object**

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
   println("Simple script")
   ```
   - **Instructions:**
     - Create a Scala file named `SimpleScript.sc`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli SimpleScript.sc
       ```

2. **Matching a Specific List**
   ```scala
   object SimpleApp extends App {
     println(s"Simple App $args")
   ```
   - **Instructions:**
     - Create a Scala file named `SimpleApp.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli SimpleApp.scala
       ```

