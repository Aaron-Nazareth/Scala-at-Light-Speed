package com.rockthejvm

object P2_Basics extends App {
  // defining a value
  val meaningOfLife: Int = 42 // Val is used to define constants that are immutable

  // Int, boolean, char, double, float, string
  val aBoolean = false

  val aString = "This is a string"
  val aComposedString = "I" + "" + "love" + "" + "Scala"
  val aInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions are structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // This works like a ternary operator
  val chainedIfExpression =
    if (meaningOfLife > 43) 56 // If condition is met then assign a value
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // entire value of the code block is equal to the last expression
    aLocalValue + 3
    }
    println(aCodeBlock)

  // define a function
  // def function(argument:type): name = {}
  def myFunction(x: Int, y: String): String = {
    y + "" + x
    }

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  /* Example of the logic behind the above function, using n = 5
  factorial(5) = 5 * factorial(4) = 5 * 24 = 120
  factorial(4) = 4 * factorial(3) = 4 * 6
  factorial(3) = 3 * factorial(2) = 3 * 2
  factorial(2) = 2 * factorial(1) = 2 * 1
  factorial(1) = 1
  */

  // In Scala, we generally don't use loops/iteration, we use recursions

  // Unit return types = no meaningful value aka "void" in other languages
  // return type of SIDE EFFECTS
  println("I love Scala")

  def myUnitReturningFunction(): Unit = {
    println("I don;t love returning unit")
  }

  val theUnit = ()

}
