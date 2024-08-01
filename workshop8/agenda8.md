### Workshop 8: Project structure

---

### **Topics**:
1. Simple Script/App
2. Simple project 
3. Compile, Test and Run project

---

### **1. Simple Script/App**

**Activities:**
1. **Simple Script**
   ```scala
   println("Simple script")
   ```
   - **Instructions:**
     - Create a Scala file named `SimpleScript.sc`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli SimpleScript.sc
       ```

2. **Simple App**
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

- **Folders structure**
  ```
  example
  ├── project.scala
  ├── README.md
  └── src
      ├── main
      │   └── scala
      │       ├── Logic.scala
      │       └── Main.scala
      └── test
          └── scala
              └── LogicSpec.scala
  ```

**Activities:**
1. **Create simple scala project folders structure**
   - Navigate to `workshop8` folder
      ```sh
      mkdir example2 
      cd example2 
      touch project.scala
      touch README.md
      mkdir -p {src/main/scala/, src/test/scala/}
      touch src/main/scala/Main.scala 
      touch src/main/scala/Logic.scala 
      touch src/test/scala/LogicSpec.scala 
      tree
      ```
    - **Instructions:**
     - Copy content of the shell script and execute it in command line.

2. **Write Logic.scala**
   ```scala
   object Logic {
     def run(value: String) = s"'$value' is running"
   }
   ```
   - **Instructions:**
     - Edit a Scala file named `Logic.scala` in `example2/src/main/scala/`.
     
3. **Write Main.scala**
   ```scala
   object Main {
     def main(args: Array[String]): Unit = {
       val logicRunResult = Logic.run(
         args.mkString(", ")
       )
       println(s"Main: Logic Run Result: $logicRunResult")
     }
   }
   ```
   - **Instructions:**
     - Edit a Scala file named `Main.scala` in `example2/src/main/scala/`.

4. **Write LogicSpec.scala**
   ```scala
   import org.scalatest.*
   import org.scalatest.matchers.*
   import org.scalatest.matchers.should.Matchers.shouldEqual
   import org.scalatest.wordspec.AnyWordSpec

   class LogicSpec extends AnyWordSpec {
     "Logic" must {
       "run scenario 1 successfully" in {
         Logic.run("a") shouldEqual "'a' is running"
       }
       "run scenario 2 successfully" in {
         Logic.run("b") shouldEqual "'b' is running"
       }
     }
   }
   ```
   - **Instructions:**
     - Edit a Scala file named `LogicSpec.scala` in `example2/src/test/scala/`.

### **3. Compile, Test and Run project**

- **Compile**
  Navigate to root of `example2` folder.
  ```sh
  scala-cli compile .
  ```
- **Test**
  ```sh
  scala-cli test .
  ```
- **Test**
  ```sh
  scala-cli run .
  ```
  
**Activities:**
1. **Execute Specs by wildcard**
   ```sh
   scala-cli test . --test-only "Logic*"
   ```
2. **Execute Spec by name**
   ```sh
   scala-cli test . --test-only "LogicSpec"
   ```
3. **Execute tests in Spec by wildcard**
   ```sh
   scala-cli test . --test-only "Logic*" -- -z "scenario"
   ```
4. **Execute test in Spec by name**
   ```sh
   scala-cli test . --test-only "Logic*" -- -t "Logic must run scenario 2 successfully"
   ```
5. **Run project with parameters**
   ```sh
   scala-cli run . -- 1 two
   ```
6. **List main classes in project**
   ```sh
   scala-cli run . --list-main-classes
   ```
7. **Run interactive mode with parameters**
   ```sh
   scala-cli run . --interactive -- 1 two
   ```
8. **Run project with specific main class with parameters**
   ```sh
   scala-cli run . --main-class Main -- 1 two
   ```
