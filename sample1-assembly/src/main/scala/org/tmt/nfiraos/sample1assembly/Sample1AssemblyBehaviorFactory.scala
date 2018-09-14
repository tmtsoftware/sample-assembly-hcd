package org.tmt.nfiraos.sample1assembly

import akka.actor.typed.scaladsl.ActorContext
import csw.command.messages.TopLevelActorMessage
import csw.framework.models.CswContext
import csw.framework.scaladsl.{ComponentBehaviorFactory, ComponentHandlers}

class Sample1AssemblyBehaviorFactory extends ComponentBehaviorFactory {

  override def handlers(
      ctx: ActorContext[TopLevelActorMessage],
      cswContext: CswContext
  ): ComponentHandlers =
    new Sample1AssemblyHandlers(ctx, cswContext)

}
