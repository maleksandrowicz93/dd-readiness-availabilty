package readiness;

import infra.EventListener;
import readiness.specificReadinessContexts.consent.ConsentsSigned;

class ConsentsSignedListener implements EventListener<ConsentsSigned> {

    private final ReadinessFacade readinessFacade;

    ConsentsSignedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(ConsentsSigned event) {
        readinessFacade.readinessCheckPassedBy(event);
    }
}
