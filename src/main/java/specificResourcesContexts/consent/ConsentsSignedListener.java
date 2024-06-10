package specificResourcesContexts.consent;

import common.EventListener;
import readiness.ReadinessFacade;

class ConsentsSignedListener implements EventListener<ConsentsSigned> {

    private final ReadinessFacade readinessFacade;

    ConsentsSignedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(ConsentsSigned event) {
        readinessFacade.removeLockFor(event.resourceId(), ConsentReadinessContextId.VALUE);
    }
}
