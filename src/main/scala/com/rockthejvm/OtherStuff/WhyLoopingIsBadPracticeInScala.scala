package com.rockthejvm.OtherStuff

object WhyLoopingIsBadPracticeInScala {

  // Java

  val x = 3 // constant - can't be reassigned
//  x = 5 // won't compile

  var y = 5
  y = 999 // This is mutable

  // imperatively = instructed coding style, e.g.:
  while (y < 9999) {
    println("I'm looping")
    y += 1
  }

  // functionally = expressions
  val result = (999 to 9999).foreach(_ => println("I'm doing this the right way!"))

  // transform a list
  List(1,2,3).map(x => x + 1) // List(2,3,4)
  List(1,2,3).flatMap(n => Seq.fill(n)(1))  //  List(1, 1,1, 1,1,1, 1,1,1,1)
  List(1,2,3).filter(n => n % 42 == 0)
  // fold, find, count, maxBy, sum, reduce

  // foreach fallacy
  List(1,2,3).foreach { x =>  // lambda = function = function object
    println(x)  // foreach use in Scala is as a HoF taking in another function
  }
  /*
  Above is the same as the following in Java:
  List<Integer> myList = ...
  for (x : myList) {
    System.out.println(x)
    }
   */

  // for comprehensions
  val pairs = for {
    x <- List(1,2,3)
    y <- List(4,5,6)
  } yield (x, y)

  // equivalent to code above
  List(1,2,3).flatMap(x => List(4,5,6).map(y => (x, y)))

}
