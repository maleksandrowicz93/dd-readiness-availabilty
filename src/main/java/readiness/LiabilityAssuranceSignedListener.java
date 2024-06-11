package readiness;

import infra.EventListener;
import readiness.specificReadinessContexts.liabilityAsusrance.LiabilityAssuranceSigned;

class LiabilityAssuranceSignedListener implements EventListener<LiabilityAssuranceSigned> {

    private final ReadinessFacade readinessFacade;

    LiabilityAssuranceSignedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(LiabilityAssuranceSigned event) {
        readinessFacade.readinessCheckPassedBy(event);
    }
}
