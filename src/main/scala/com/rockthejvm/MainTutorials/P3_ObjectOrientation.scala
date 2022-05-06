package com.rockthejvm.MainTutorials

object P3_ObjectOrientation extends App {

  // Java equivalent would be: public static void main(String[] args)

  // class and instance
  class Animal { // class
    // define fields
    val age: Int = 0

    // define methods
    def eat() = println("I'm eating")
  }

  val anAnimal = new Animal // instance

  // inheritance
  class Dog(val name: String) extends Animal // constructor definition

  val aDog = new Dog("Rory")
  // constructor arguments are not fields - need to put a val before the constructor argument
  println(aDog.name)

  // sub-type polymorphism
  val aDeclaredAnimal: Animal = new Dog("George")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default this is public, but can be restricted adding protected or private

    def walk(): Unit
  }

  // "interface" - ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")
    // override key used where we implement a method that is also present in a super-type

    override def ?!(thought: String): Unit = println(s"I was thinking $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog) // one notation
  aCroc eat aDog // another notation
  // infix notation = object method argument
  aCroc.?!("What if I could fly?")

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent to the above

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat almost anything")
  }

  /*
  What we're telling the compiler from the above anonymous classes code:

  class Carnivore_Anonymous_35728 extends Carnivore {
  override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat almost anything")
  }

  val dinosaur = new Carnivore_Anonymous_35728
  */

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 347372

    def mySpecialMethod(): Int = 3728

    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to above notation

  object Animal { // "companion" to the Animal class as they are associated by name
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
  case classes = lightweight data structures with some boilerplate

  Automatically generates the following:
  - sensible equals and hash code
  - serialisation
  - companion with apply
   */

  case class Person(name: String, age: Int)

  // may be constructed without keyword "new"
  val aaron = Person("Aaron", 24) // Same as Person.apply("Aaron", 24)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    // some code that will execute no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T

    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] = List(1, 2, 3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head

  // Key notes:

  // 1. In Scala we operate with immutable values/objects
  // Any modification to an object must return a new object
  /*
  Benefits:
  1) Speeds up development tremendously in multithreaded/distributed environments
  2) Helps makes sense of code - "reasoning about"
   */
  val reversedList = aList.reverse // returns a new list

  // 2. Scala is closest to OOP ideal - no values or methods fall outside a class/object

}
