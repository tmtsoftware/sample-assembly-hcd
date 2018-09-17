package org.tmt.nfiraos.sample1hcd

import akka.actor.typed.scaladsl.ActorContext
import csw.command.messages.TopLevelActorMessage
import csw.framework.models.CswContext
import csw.framework.scaladsl.ComponentHandlers
import csw.location.api.models.TrackingEvent
import csw.params.commands.{CommandResponse, ControlCommand}

import scala.concurrent.{ExecutionContextExecutor, Future}

/**
 * Domain specific logic should be written in below handlers.
 * This handlers gets invoked when component receives messages/commands from other component/entity.
 * For example, if one component sends Submit(Setup(args)) command to Sample1Hcd,
 * This will be first validated in the supervisor and then forwarded to Component TLA which first invokes validateCommand hook
 * and if validation is successful, then onSubmit hook gets invoked.
 * You can find more information on this here : https://tmtsoftware.github.io/csw-prod/framework.html
 */
class Sample1HcdHandlers(
    ctx: ActorContext[TopLevelActorMessage],
    cswContext: CswContext
) extends ComponentHandlers(ctx, cswContext) {

  implicit val ec: ExecutionContextExecutor = ctx.executionContext

  override def initialize(): Future[Unit] = Future.successful({})

  override def onLocationTrackingEvent(trackingEvent: TrackingEvent): Unit = ???

  override def validateCommand(controlCommand: ControlCommand): CommandResponse = ???

  override def onSubmit(controlCommand: ControlCommand): Unit = {
    println("Submit command received by hcd")
  }

  override def onOneway(controlCommand: ControlCommand): Unit = ???

  override def onShutdown(): Future[Unit] = Future {
    println("Shutdown command received by hcd")
  }

  override def onGoOffline(): Unit = ???

  override def onGoOnline(): Unit = ???

}
