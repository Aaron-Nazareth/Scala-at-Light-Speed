package com.rockthejvm.MainTutorials

object P4_FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // Invoking bob as a function === bob.apply(43)

  /*
  Scala runs on the JVM

  Functional programming:
  - compose functions
  - pass functions as args
  - return functions as results

  Conclusion: FunctionX = Function1, Function2, ... Function22 (22 is max number of args you can pass to a function)
   */

  val simpleIncrementer = new Function[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // result = 24
  simpleIncrementer(23) // result also = 24, same as above
  // defined a function!

  // All Scala functions are instances of these FunctionX types!

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", "Scala") // becomes "I love Scala"

  // arrow function shorthand
  val doubler: Int => Int = (x: Int) => 2 * x // Shorter arrow function
  doubler(4) // equates to 8

  /*
   above is equivalent to writing the much longer:

   val doubler: Function1[Int, Int] = new Function1[Int, Int] {
    override def apply(x: Int) = 2 * x
   }
   */

  // higher-order functions: take functions as args/return functions as results
  val aMappedList = List(1, 2, 3).map(x => x + 1) // HOF
  //  println(aMappedList)
  val aFlatMappedList = List(1, 2, 3).flatMap(x => List(x, 2 * x))
  //  println(aFlatMappedList)
  val aFilteredList = List(1, 2, 3, 4, 5).filter(x => x <= 3)
  //  println(aFilteredList)
  val alternativeFilteredList = List(1, 2, 3, 4, 5).filter(_ <= 3) // equivalent to above filtered list

  // all pairs between the numbers 1, 2, 3 and the letters 'a', 'b', 'c'
  val allPairs = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairs)

  // for comprehensions
  val alternativeAllPairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to map/flatMap chain above
  println(alternativeAllPairs)

  // ============== COLLECTIONS ================

  // lists
  val aList = List(1, 2, 3, 4, 5)
  val FirstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // :: is how you prepend lists - result in this case is List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // results in List(0,1,2,3,4,5,6)

  // sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3) // Seq.apply(1,2,3)
  // Seq mainly used to access an element at a given index
  val accessedElement = aSequence(1) // the element at index 1 is 2

  // vectors - fast sequence implementation
  val aVector = Vector(1, 2, 3, 4, 5)

  // sets = no duplicates
  val aSet = Set(1, 2, 3, 4, 1, 2, 3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // returns false
  val anAddedSet = aSet + 5 // Set(1,2,3,4,5) - order may vary as order not important in a set collection
  val aRemovedSet = aSet - 3 // Set(1,2,4)

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList // List(2,4,6,8,...,2000)
  // note - .toSet and .toSeq also exist

  // tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 6437812),
    "Jane" -> 3272854 // Same as ("Jane", 3272854)
  )

}
