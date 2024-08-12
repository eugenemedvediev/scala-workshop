### Workshop 10: Creating a Minimal SBT Project with Console Input

**Objective**: By the end of this workshop, you will know how to set up a minimal SBT (Simple Build Tool) project, configure it to work with console input, and write a Scala script that uses `for-comprehension` to interact with user input.

---

### **Topics**:
1. Introduction to SBT
2. Setting Up a Minimal SBT Project
3. Writing a Scala Script to Handle Console Input
4. Using `for-comprehension` with Console Input
5. Running the Project

### **Activities**:
- Setting up an SBT project from scratch.
- Writing and running a Scala script that interacts with the console using `for-comprehension`.
- Hands-on practice with SBT commands.

---

### **1. Introduction to SBT**

**a. What is SBT?**

- **Definition**: SBT (Simple Build Tool) is a popular build tool for Scala and Java projects, providing a way to compile code, run tests, and package applications.
- **Key Features**:
  - Dependency management.
  - Support for incremental compilation.
  - Integration with IDEs and editors.

---

### **2. Setting Up a Minimal SBT Project**

**a. Create the Project Directory Structure**

1. **Open a terminal and create a new directory for your project**:
   ```sh
   mkdir MinimalSbtProject
   cd MinimalSbtProject
   ```

2. **Create the directory structure**:
   ```sh
   mkdir -p src/main/scala src/test/scala
   ```

**b. Create the `build.sbt` File**

1. **Inside the project directory, create a `build.sbt` file**:
   ```sh
   touch build.sbt
   ```

2. **Open `build.sbt` and add the following minimal configuration**:
   ```scala
   name := "MinimalSbtProject"

   version := "0.1"

   scalaVersion := "2.13.12"
   ```

**c. Create a Scala File**

1. **In the `src/main/scala` directory, create a Scala file named `Main.scala`**:
   ```sh
   touch src/main/scala/Main.scala
   ```

2. **Open `Main.scala` and add a simple `App`**:
   ```scala
   object Main extends App {
     println("Welcome to the Minimal SBT Project!")
   }
   ```

**Activities:**
1. **Initialize the SBT Project**
   - Ensure the project is set up by running `sbt` in the terminal within the project directory:
     ```sh
     sbt
     ```
   - Once inside the SBT console, run the project:
     ```sh
     run
     ```

---

### **3. Writing a Scala Script to Handle Console Input**

**a. Update the `Main.scala` File**

1. **Modify `Main.scala` to read input from the console**:
   ```scala
   object Main extends App {
     println("Please enter your name:")
     val name = scala.io.StdIn.readLine()

     println(s"Hello, $name!")
   }
   ```

**b. Explanation of the Code**

- **`scala.io.StdIn.readLine`**: This function reads a line of input from the console as a `String`.
- **`println(s"Hello, $name!")`**: This line uses string interpolation to include the user's input in the output.

**Activities:**
1. **Run the Project**
   - Compile and run the project again using SBT:
     ```sh
     sbt run
     ```
   - Verify that the console prompts you for input and responds appropriately.

---

### **4. Using `for-comprehension` with Console Input**

**a. Modify `Main.scala` to Use `for-comprehension`**

1. **Update the code to collect multiple inputs using `for-comprehension`**:
   ```scala
   object Main extends App {
     def getInput(prompt: String): Option[String] = {
       println(prompt)
       val input = scala.io.StdIn.readLine()
       if (input.nonEmpty) Some(input) else None
     }

     val result = for {
       name <- getInput("Please enter your name:")
       age <- getInput("Please enter your age:")
       city <- getInput("Please enter your city:")
     } yield s"Name: $name, Age: $age, City: $city"

     result match {
       case Some(data) => println(s"User Details: $data")
       case None => println("Some input was missing, exiting...")
     }
   }
   ```

**b. Explanation of the Code**

- **`getInput` Function**: Prompts the user for input and returns an `Option[String]`. If the input is empty, it returns `None`.
- **`for-comprehension`**: Used to sequentially gather user input. If any input is missing (`None`), the entire comprehension returns `None`.
- **`result match { ... }`**: Pattern matching is used to handle the case where some input was missing.

**Activities:**
1. **Run the Project with `for-comprehension`**
   - Execute the project using SBT:
     ```sh
     sbt run
     ```
   - Test the script by providing different sets of inputs, including empty inputs to see how it handles missing data.

---

### **5. Running the Project**

**a. Run the Project from the Command Line**

1. **Ensure that SBT is running and your project is compiled**:
   - From the project directory, run:
     ```sh
     sbt run
     ```

**b. Interact with the Program**

- **Input different values**: Test the script by entering various inputs to verify that it behaves as expected.

**Activities:**
1. **Final Test**
   - Test the project by running it multiple times with different inputs.
   - Observe how the `for-comprehension` handles both complete and incomplete inputs.

---

