//import akka.http.scaladsl.server.Directives
//import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
//import spray.json._
//
//
//
//
//// use it wherever json (un)marshalling is needed
//class MyJsonService extends Directives with JsonSupport {
//
//  // format: OFF
//  val route =
//    get {
//      pathSingleSlash {
//        complete(Item("thing", 42)) // will render as JSON
//      }
//    } ~
//      post {
//        entity(as[Order]) { order => // will unmarshal JSON to Order
//          val itemsCount = order.items.size
//          val itemNames = order.items.map(_.name).mkString(", ")
//          complete(s"Ordered $itemsCount items: $itemNames")
//        }
//      }
//  // format: ON
//}