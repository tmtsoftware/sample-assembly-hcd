package org.tmt.nfiraos.sample1hcd

import akka.actor.typed.scaladsl.ActorContext
import csw.command.client.internal.messages.TopLevelActorMessage
import csw.framework.models.CswContext
import csw.framework.scaladsl.{ComponentBehaviorFactory, ComponentHandlers}

class Sample1HcdBehaviorFactory extends ComponentBehaviorFactory {

  override def handlers(
      ctx: ActorContext[TopLevelActorMessage],
      cswContext: CswContext
  ): ComponentHandlers =
    new Sample1HcdHandlers(ctx, cswContext)

}
