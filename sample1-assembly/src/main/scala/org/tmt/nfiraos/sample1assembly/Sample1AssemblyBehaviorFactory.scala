package org.tmt.nfiraos.sample1assembly

import akka.actor.typed.scaladsl.ActorContext
import csw.framework.models.CswServices
import csw.framework.scaladsl.{ComponentBehaviorFactory, ComponentHandlers}
import csw.messages.TopLevelActorMessage

class Sample1AssemblyBehaviorFactory extends ComponentBehaviorFactory {

  override def handlers(
      ctx: ActorContext[TopLevelActorMessage],
      cswServices: CswServices
  ): ComponentHandlers =
    new Sample1AssemblyHandlers(ctx, cswServices)
}
