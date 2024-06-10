package readiness.specificReadinessContexts.consent;

import common.EventListener;
import readiness.ReadinessFacade;

class ConsentsSignedListener implements EventListener<ConsentsSigned> {

    private final ReadinessFacade readinessFacade;

    ConsentsSignedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(ConsentsSigned event) {
        readinessFacade.readinessCheckPassedBy(event.resourceId(), ConsentReadinessContextId.VALUE);
    }
}
