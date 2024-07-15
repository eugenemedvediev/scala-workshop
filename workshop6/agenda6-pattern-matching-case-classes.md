### Pattern Matching for Case Classes

**Objective**: By the end of this section, students will understand how to use pattern matching with case classes in Scala to decompose objects and extract data easily.

---

### **Topics**:
1. Basic Pattern Matching with Case Classes
2. Nested Pattern Matching
3. Using Guards in Pattern Matching
4. Sealed Traits and Exhaustive Matching

### **Activities**:
- Writing Scala scripts to practice pattern matching with case classes.
- Exercises and hands-on coding.

---

### **1. Basic Pattern Matching with Case Classes**

**a. Introduction**

Pattern matching with case classes allows you to extract and manipulate data in a clear and concise way. It's particularly useful for decomposing complex data structures.

**b. Syntax and Example**

- **Syntax:**
  ```scala
  case class ClassName(param1: Type1, param2: Type2)

  val instance = ClassName(value1, value2)

  instance match {
    case ClassName(param1, param2) => // code to execute
  }
  ```

- **Example:**
  ```scala
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 25)

  bob match {
    case Person(name, age) => println(s"Name: $name, Age: $age")
  }
  ```

**Activities:**
1. **Basic Pattern Matching**
   ```scala
   case class Car(make: String, model: String, year: Int)

   object CarMatchDemo extends App {
     val car = Car("Toyota", "Corolla", 2020)

     car match {
       case Car(make, model, year) => println(s"Make: $make, Model: $model, Year: $year")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `CarMatchDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli CarMatchDemo.scala
       ```

---

### **2. Nested Pattern Matching**

**a. Introduction**

Nested pattern matching allows you to match and extract data from nested case classes.

**b. Example**

- **Nested Case Classes:**
  ```scala
  case class Address(city: String, country: String)
  case class Employee(name: String, address: Address)

  val employee = Employee("John", Address("New York", "USA"))

  employee match {
    case Employee(name, Address(city, country)) => println(s"Name: $name, City: $city, Country: $country")
  }
  ```

**Activities:**
1. **Nested Pattern Matching**
   ```scala
   case class Engine(horsepower: Int)
   case class Car(make: String, model: String, engine: Engine)

   object NestedMatchDemo extends App {
     val car = Car("Ford", "Mustang", Engine(450))

     car match {
       case Car(make, model, Engine(hp)) => println(s"Make: $make, Model: $model, Horsepower: $hp")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `NestedMatchDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli NestedMatchDemo.scala
       ```

---

### **3. Using Guards in Pattern Matching**

**a. Introduction**

Guards are additional conditions that can be used in pattern matching to further refine matches.

**b. Example**

- **Syntax and Usage:**
  ```scala
  case class Person(name: String, age: Int)

  val alice = Person("Alice", 29)

  alice match {
    case Person(name, age) if age > 18 => println(s"$name is an adult")
    case Person(name, age) => println(s"$name is not an adult")
  }
  ```

**Activities:**
1. **Pattern Matching with Guards**
   ```scala
   case class Product(name: String, price: Double)

   object GuardMatchDemo extends App {
     val product = Product("Laptop", 1500.0)

     product match {
       case Product(name, price) if price > 1000 => println(s"$name is expensive")
       case Product(name, price) => println(s"$name is affordable")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `GuardMatchDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli GuardMatchDemo.scala
       ```

---

### **4. Sealed Traits and Exhaustive Matching**

**a. Introduction**

Using sealed traits with case classes allows for exhaustive pattern matching, ensuring that all possible cases are handled.

**b. Example**

- **Defining Sealed Traits and Case Classes:**
  ```scala
  sealed trait Shape
  case class Circle(radius: Double) extends Shape
  case class Rectangle(width: Double, height: Double) extends Shape

  def describeShape(shape: Shape): String = shape match {
    case Circle(radius) => s"A circle with radius $radius"
    case Rectangle(width, height) => s"A rectangle with width $width and height $height"
  }

  val myShape: Shape = Circle(5.0)
  println(describeShape(myShape)) // Output: A circle with radius 5.0
  ```

**Activities:**
1. **Exhaustive Pattern Matching**
   ```scala
   sealed trait Animal
   case class Dog(name: String) extends Animal
   case class Cat(name: String) extends Animal

   def describeAnimal(animal: Animal): String = animal match {
     case Dog(name) => s"This is a dog named $name"
     case Cat(name) => s"This is a cat named $name"
   }

   object SealedTraitMatchDemo extends App {
     val myPet: Animal = Dog("Buddy")
     println(describeAnimal(myPet)) // Output: This is a dog named Buddy
   }
   ```
   - **Instructions:**
     - Create a Scala file named `SealedTraitMatchDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli SealedTraitMatchDemo.scala
       ```

---

### **Additional Resources**
- **Scala Documentation:** [Pattern Matching](https://docs.scala-lang.org/tour/pattern-matching.html)
- **Scala Exercises:** [Scala Exercises](https://www.scala-exercises.org/) for hands-on practice.

---

By the end of this section, students will have a thorough understanding of how to use pattern matching with case classes in Scala. They will learn to decompose objects, handle nested data structures, apply guards for more specific matches, and ensure exhaustive pattern matching with sealed traits. The hands-on activities will reinforce these concepts, providing practical experience.
