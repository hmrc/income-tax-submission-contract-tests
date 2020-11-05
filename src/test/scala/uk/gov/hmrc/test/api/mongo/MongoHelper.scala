package uk.gov.hmrc.test.api.mongo

import java.util.concurrent.TimeUnit

import org.mongodb.scala._

import scala.concurrent.Await
import scala.concurrent.duration._

object MongoHelper {

  implicit class DocumentObservable[C](val observable: Observable[Document]) extends ImplicitObservable[Document] {
    override val converter: Document => String = doc => doc.toJson
  }

  implicit class GenericObservable[C](val observable: Observable[C]) extends ImplicitObservable[C] {
    override val converter: C => String = doc => doc.toString
  }

  trait ImplicitObservable[C] {
    val observable: Observable[C]
    val converter: C => String

    def results(): Seq[C] = Await.result(observable.toFuture(), 10.seconds)

    def headResult(): C = Await.result(observable.head(), 10.seconds)

    def printResults(initial: String = ""): Unit = {
      if (initial.length > 0) print(initial)
      results().foreach(res => println(converter(res)))
    }

    def printHeadResult(initial: String = ""): Unit = println(s"$initial${converter(headResult())}")
  }

}