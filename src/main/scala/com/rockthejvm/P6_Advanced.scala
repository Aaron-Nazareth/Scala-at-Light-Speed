package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object P6_Advanced extends App{

  /** =============== Lazy evaluation =============== */
  lazy val aLazyValue = "random"
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!") // I feel personally attacked by this
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1
  // lazy values are useful in infinite collections

  /** ============= "pseudo-collections": Option type, Try type ============= */

  def methodWhichCanReturnNull(): String = "hello, Scala"
  /* This could be used, but we don't need it since we have the Option type
  if (methodWhichCanReturnNull() == null) {
    // defensive code against null
  }
   */
  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I have obtained nothing"
  }
  // map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException()
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(ex) => s"I have obtained an exception: $ex"
  }
  // map, flatMap, filter

  /**
   Evaluate something on another thread
   (asynchronous programming)
   */

  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  }

  Thread.sleep(2000)

  // Future is a "collection" which contains a value when it's evaluated
  // Future is composable with map, flatMap and filter
  // Future, Try and Option types are known as "monads"

  /**
   Implicits basics
   */
  // 1. Implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs)  // aMethodWithImplicitArgs(myImplicitInt)

  // 2. Implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }

  println(23.isEven())  // compiler essentially does: new MyRichInteger(23).isEven()
  // use this carefully

}
