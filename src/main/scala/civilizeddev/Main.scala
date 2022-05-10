package civilizeddev

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import civilizeddev.machine.MachineService
import civilizeddev.machine.MachineServiceImpl
import civilizeddev.user.UserService
import civilizeddev.user.UserServiceImpl
import com.softwaremill.macwire._
import org.slf4j.LoggerFactory
import sttp.tapir.openapi._
import sttp.tapir.server.akkahttp.AkkaHttpServerInterpreter
import sttp.tapir.swagger.bundle.SwaggerInterpreter

import scala.util.Failure
import scala.util.Success

object Main extends App {
  private val logger = LoggerFactory.getLogger(this.getClass)

  implicit val system: ActorSystem = ActorSystem("system")

  import system.dispatcher

  lazy val userService: UserService       = wire[UserServiceImpl]
  lazy val machineService: MachineService = wire[MachineServiceImpl]
  lazy val routesProvider: RoutesProvider = wire[RoutesProvider]

  val endpoints = routesProvider.routes

  val docsEndpoints = SwaggerInterpreter()
    .fromServerEndpoints(
      endpoints,
      Info(
        title = "My App",
        version = "1.0.0",
        description = Some("스칼라 웹 애플리케이션 템플릿"),
      )
    )

  val route = AkkaHttpServerInterpreter().toRoute(endpoints ++ docsEndpoints)

  val interface = sys.env.getOrElse("HTTP_HOST", "localhost")
  val port      = sys.env.getOrElse("HTTP_PORT", "9000").toInt

  val binding = Http()
    .newServerAt(interface, port)
    .bindFlow(route)

  binding.onComplete {
    case Success(_) =>
      logger.info(s"Server is listening on http://$interface:$port")
    case Failure(exception) =>
      logger.error(s"Failure : $exception")
      system.terminate()
  }
}
