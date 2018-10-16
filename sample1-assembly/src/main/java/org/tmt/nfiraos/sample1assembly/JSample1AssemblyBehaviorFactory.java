package org.tmt.nfiraos.sample1assembly;

import akka.actor.typed.javadsl.ActorContext;
import csw.command.client.internal.messages.TopLevelActorMessage;
import csw.framework.javadsl.JComponentBehaviorFactory;
import csw.framework.javadsl.JComponentHandlers;
import csw.framework.models.JCswContext;

public class JSample1AssemblyBehaviorFactory extends JComponentBehaviorFactory {

    @Override
    public JComponentHandlers jHandlers(ActorContext<TopLevelActorMessage> ctx, JCswContext cswCtx) {
        return new JSample1AssemblyHandlers(ctx, cswCtx);
    }
}
