### Workshop 5: Case Classes in Scala

---

### **Topics**:
1. Introduction to Case Classes
2. Defining Case Classes
3. Benefits of Case Classes
4. Using Case Classes
5. Pattern Matching with Case Classes

### **Activities**:
- Writing Scala scripts to define and use case classes.
- Exercises and hands-on coding.

---

### **1. Introduction to Case Classes**

Case classes in Scala are a special type of class that are optimized for use in pattern matching. They provide a concise way to define immutable data structures with built-in methods for comparison, hashing, and copying.

**Key Features:**
- Immutable by default.
- Automatically provide `toString`, `equals`, `hashCode`, and `copy` methods.
- Can be used in pattern matching.

---

### **2. Defining Case Classes**

**a. Syntax and Example**

- **Syntax:**
  ```scala
  case class ClassName(param1: Type1, param2: Type2, ...)
  ```

- **Example:**
  ```scala
  case class Person(name: String, age: Int)
  ```

**b. Instantiating Case Classes**

- **Example:**
  ```scala
  val person = Person("Alice", 30)
  println(person.name) // Alice
  println(person.age)  // 30
  ```

**Activities:**
1. **Define and Instantiate a Case Class**
   ```scala
   case class Book(title: String, author: String, year: Int)

   object BookDemo extends App {
     val book = Book("1984", "George Orwell", 1949)
     println(s"Title: ${book.title}, Author: ${book.author}, Year: ${book.year}")
   }
   ```
   - **Instructions:**
     - Create a Scala file named `BookDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli BookDemo.scala
       ```

---

### **3. Benefits of Case Classes**

**a. Automatic `toString`, `equals`, and `hashCode` Methods**

- **Example:**
  ```scala
  val person1 = Person("Alice", 30)
  val person2 = Person("Alice", 30)

  println(person1.toString)  // Person(Alice,30)
  println(person1 == person2) // true
  ```

**b. Immutable by Default**

- **Example:**
  ```scala
  val person = Person("Alice", 30)
  // person.age = 31 // This will result in a compilation error
  ```

**c. `copy` Method**

- **Example:**
  ```scala
  val person = Person("Alice", 30)
  val olderPerson = person.copy(age = 31)

  println(person)      // Person(Alice,30)
  println(olderPerson) // Person(Alice,31)
  ```

**Activities:**
1. **Using `copy` Method**
   ```scala
   case class Car(make: String, model: String, year: Int)

   object CarDemo extends App {
     val car = Car("Toyota", "Corolla", 2020)
     val newCar = car.copy(year = 2021)

     println(car)    // Car(Toyota,Corolla,2020)
     println(newCar) // Car(Toyota,Corolla,2021)
   }
   ```
   - **Instructions:**
     - Create a Scala file named `CarDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli CarDemo.scala
       ```

---

### **4. Using Case Classes**

**a. Methods and Fields**

- **Example:**
  ```scala
  case class Rectangle(width: Double, height: Double) {
    def area: Double = width * height
  }

  object RectangleDemo extends App {
    val rectangle = Rectangle(3.0, 4.0)
    println(s"Area: ${rectangle.area}") // Area: 12.0
  }
  ```

**Activities:**
1. **Define a Case Class with Methods**
   ```scala
   case class Circle(radius: Double) {
     def area: Double = math.Pi * radius * radius
     def circumference: Double = 2 * math.Pi * radius
   }

   object CircleDemo extends App {
     val circle = Circle(5.0)
     println(s"Area: ${circle.area}")
     println(s"Circumference: ${circle.circumference}")
   }
   ```
   - **Instructions:**
     - Create a Scala file named `CircleDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli CircleDemo.scala
       ```

---

### **5. Pattern Matching with Case Classes**

**a. Basic Pattern Matching**

- **Example:**
  ```scala
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 25)

  bob match {
    case Person(name, age) => println(s"Name: $name, Age: $age")
  }
  ```

**b. Advanced Pattern Matching**

- **Example:**
  ```scala
  case class Address(city: String, country: String)
  case class Employee(name: String, address: Address)

  val employee = Employee("John", Address("New York", "USA"))

  employee match {
    case Employee(name, Address(city, country)) => 
      println(s"Name: $name, City: $city, Country: $country")
  }
  ```

**Activities:**
1. **Pattern Matching with Case Classes**
   ```scala
   case class Point(x: Int, y: Int)

   object PointDemo extends App {
     val point = Point(3, 4)

     point match {
       case Point(x, y) => println(s"Point coordinates: ($x, $y)")
     }
   }
   ```
   - **Instructions:**
     - Create a Scala file named `PointDemo.scala`.
     - Write the script and run it using `scala-cli`:
       ```sh
       scala-cli PointDemo.scala
       ```

### **Additional Resources**
- **Scala Documentation:** [Case Classes](https://docs.scala-lang.org/tour/case-classes.html)
