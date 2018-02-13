package main.scala

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import spray.json.DefaultJsonProtocol._


// Model
final case class Item(name: String, id: Long,age:Int)

final case class Order(items: List[Item])


// SIMPLE SEED REST API AKKA HTTP


// WebServer
object WebServer {
  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  // formats for unmarshalling and marshalling
  implicit val itemFormat = jsonFormat3(Item)

  def main(args: Array[String]) {

    // akka route
    // see docs : https://doc.akka.io/docs/akka-http/current/routing-dsl/overview.html
    val route: Route =
      get {
        pathPrefix("item" / LongNumber) { id =>
          complete(Item("Life", 42,18))
        } ~
          path("ping") {
            complete("Pong")
          }
      }
    // see PUT & POST


    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
    println(s"Server online at http://localhost:8080 ...")

  }
}