package org.tmt.nfiraos.sample1assembly;

import akka.actor.typed.javadsl.ActorContext;
import csw.command.client.CommandResponseManager;
import csw.command.client.internal.messages.TopLevelActorMessage;
import csw.command.client.internal.models.framework.ComponentInfo;
import csw.event.api.javadsl.IEventService;
import csw.framework.CurrentStatePublisher;
import csw.framework.javadsl.JComponentHandlers;
import csw.framework.models.JCswContext;
import csw.location.api.javadsl.ILocationService;
import csw.location.api.models.TrackingEvent;
import csw.logging.javadsl.ILogger;
import csw.params.commands.CommandResponse;
import csw.params.commands.ControlCommand;

import java.util.concurrent.CompletableFuture;

/**
 * Domain specific logic should be written in below handlers.
 * This handlers gets invoked when component receives messages/commands from other component/entity.
 * For example, if one component sends Submit(Setup(args)) command to Sample1Hcd,
 * This will be first validated in the supervisor and then forwarded to Component TLA which first invokes validateCommand hook
 * and if validation is successful, then onSubmit hook gets invoked.
 * You can find more information on this here : https://tmtsoftware.github.io/csw-prod/framework.html
 */
public class JSample1AssemblyHandlers extends JComponentHandlers {

    private ILogger log;
    private CommandResponseManager commandResponseManager;
    private CurrentStatePublisher currentStatePublisher;
    private ActorContext<TopLevelActorMessage> actorContext;
    private ILocationService locationService;
    private IEventService eventService;
    private ComponentInfo componentInfo;

    JSample1AssemblyHandlers(
            ActorContext<TopLevelActorMessage> ctx,
            JCswContext cswContext
    ) {
        super(ctx, cswContext);
        this.currentStatePublisher = cswContext.currentStatePublisher();
        this.log = cswContext.loggerFactory().getLogger(this.getClass());
        this.commandResponseManager = cswContext.commandResponseManager();
        this.actorContext = ctx;
        this.locationService = cswContext.locationService();
        this.eventService = cswContext.eventService();
        this.componentInfo = cswContext.componentInfo();
    }

    @Override
    public CompletableFuture<Void> jInitialize() {
        return CompletableFuture.runAsync(() -> {

        });
    }

    @Override
    public CompletableFuture<Void> jOnShutdown() {
        return CompletableFuture.runAsync(() -> {

        });
    }

    @Override
    public CommandResponse.SubmitResponse onSubmit(ControlCommand controlCommand) {
        return null;
    }

    @Override
    public void onOneway(ControlCommand controlCommand) {

    }

    @Override
    public void onLocationTrackingEvent(TrackingEvent trackingEvent) {

    }

    @Override
    public CommandResponse.ValidateCommandResponse validateCommand(ControlCommand controlCommand) {
        return null;
    }

    @Override
    public void onGoOffline() {

    }

    @Override
    public void onGoOnline() {

    }
}
