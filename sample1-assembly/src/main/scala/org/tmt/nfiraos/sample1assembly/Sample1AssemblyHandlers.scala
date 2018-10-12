package org.tmt.nfiraos.sample1assembly

import akka.Done
import akka.actor.typed.scaladsl.ActorContext
import akka.actor.typed.scaladsl.adapter.TypedActorSystemOps
import akka.stream.scaladsl.Source
import akka.stream.{ActorMaterializer, Materializer}
import csw.command.messages.TopLevelActorMessage
import csw.framework.models.CswContext
import csw.framework.scaladsl.ComponentHandlers
import csw.location.api.models.TrackingEvent
import csw.params.commands.CommandResponse.{Completed, SubmitResponse, ValidationResponse}
import csw.params.commands.{CommandName, CommandResponse, ControlCommand, Setup}
import csw.params.core.generics.KeyType.{IntKey, StringKey}
import csw.params.core.states.{CurrentState, StateName}

import scala.concurrent.duration.{DurationInt, FiniteDuration}
import scala.concurrent.{ExecutionContextExecutor, Future}

/**
 * Domain specific logic should be written in below handlers.
 * This handlers gets invoked when component receives messages/commands from other component/entity.
 * For example, if one component sends Submit(Setup(args)) command to Sample1Hcd,
 * This will be first validated in the supervisor and then forwarded to Component TLA which first invokes validateCommand hook
 * and if validation is successful, then onSubmit hook gets invoked.
 * You can find more information on this here : https://tmtsoftware.github.io/csw-prod/framework.html
 */
class Sample1AssemblyHandlers(
    ctx: ActorContext[TopLevelActorMessage],
    cswContext: CswContext
) extends ComponentHandlers(
      ctx,
      cswContext
    ) {

  implicit val ec: ExecutionContextExecutor = ctx.executionContext
  implicit val mat: Materializer            = ActorMaterializer()(ctx.system.toUntyped)

  override def initialize(): Future[Unit] = Future.successful({})

  override def onLocationTrackingEvent(trackingEvent: TrackingEvent): Unit = {}

  override def validateCommand(controlCommand: ControlCommand): ValidationResponse = {
    CommandResponse.Accepted(controlCommand.runId)
  }

  override def onSubmit(controlCommand: ControlCommand): SubmitResponse = {
    Thread.sleep(10000)
    println("Submit command received by assembly")
    Completed(controlCommand.runId)
  }

  override def onOneway(controlCommand: ControlCommand): Unit = {
    controlCommand match {
      case s @ Setup(_, _, CommandName("filter-move"), _, _)    => delegateToHcd("filter", 1.second, s)
      case s @ Setup(_, _, CommandName("disperser-move"), _, _) => delegateToHcd("disperser", 2500.millis, s)
      case _                                                    => println("OneWay command received by assembly")
    }
  }

  def delegateToHcd(hcdName: String, delay: FiniteDuration, setup: Setup): Future[Done] = {
    val key       = IntKey.make(s"$hcdName-position")
    val nameParam = setup.get(StringKey.make("name"))
    Source
      .tick(0.millis, delay, ())
      .zipWithIndex
      .map {
        case (_, index) =>
          cswContext.currentStatePublisher.publish(
            CurrentState(
              cswContext.componentInfo.prefix,
              StateName(hcdName),
              Set(key.set(index.toInt)) ++ nameParam
            )
          )
      }
      .take(20)
      .runForeach(_ => ())
  }

  override def onShutdown(): Future[Unit] = Future {
    println("Shutdown command received by assembly")
  }

  override def onGoOffline(): Unit = {}

  override def onGoOnline(): Unit = {}

}
