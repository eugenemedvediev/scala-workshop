object TraitsAndObjects {

  /* sealed keyword means that all the classes or objects
  which will extend this trait should be located in the same scala file
   */
  /* This particular trait called Marker Trait, because it has no body and
  uses just to be able to group classes which extends this trait by this quality
   */
  sealed trait CanSeeInTheDark

  // The same as above trait
  sealed trait CanSmellMoreThanOther

  /* This trait has 2 methods:
  - makeSound method has no body which means,
  whoever extends this trait should provide the body for this method
  - amountOfLegs has implemented body, which will be used by whoever extends this trait.
   */
  sealed trait Animal {
    def makeSound(): String
    def amountOfLegs(): Unit = println("4 legs")
  }

  /* object Dog extends Animal trait and CanSeeInTheDark trait.
  first keyword for extension should be 'extend' keyword all following should use 'with' keyword:
   */
  object Dog extends Animal with CanSmellMoreThanOther {
    // Dog provides body (after = symbol)
    def makeSound(): String = "bark"
    // Dog introduces the own method
    def dogSpecificMethod(): Unit = ()
  }

  /* Note that Cat is the class and has 'name' parameter.
  It means that to create Cat you need to use 'new' keyword:
  new Cat("Kitty")
   */
  class Cat(name: String) extends Animal with CanSeeInTheDark {
    // Implementation of makeSound method from Animal trait
    def makeSound(): String = "meaw"
    // Cat's specific method
    def catSpecificMethod(): Unit = ()
  }

  // Main method with the logic for TraitAndObjects object
  def main(args: Array[String]): Unit = {

    // We use Dog directly, because it is Singleton
    println(s"Sound ${Dog.makeSound()}")

    // We need to use 'new' keyword to create Cat class instance.
    val cat = new Cat("Pushynka")
    println(s"Sound ${cat.makeSound()}")

    /* We specify the list of Animals, where we put cat and dog.
    Because they both extends Animal, we can put them in the same list of Animals.
     */
    val list = List(cat, Dog)

    /*We can't put cat and dog to Dog's list or Cat's list
     */
    // val gods: List[Dog.type] = List(cat, Dog)
    // val cats: List[Cat] = List(cat, Dog)

    // ADVANCED: I will explain in the class
    // With foreach we iterate over list and x represent every element in the loop
    list.foreach(x => x.makeSound())

    // The same, but we us pattern match to understand the real type of the Animal
    list.foreach(animal =>
      animal match
        case dog: Dog.type => {
          dog.dogSpecificMethod()
          dog.amountOfLegs()
        }
        case cat: Cat => cat.catSpecificMethod()
    )

    // The same, but more short version without specifying 'animal => animal match'
    list.foreach {
      case d: Dog.type => {
        d.dogSpecificMethod()
        d.amountOfLegs()
      }
      case c: Cat => c.catSpecificMethod()
    }
  }

}
