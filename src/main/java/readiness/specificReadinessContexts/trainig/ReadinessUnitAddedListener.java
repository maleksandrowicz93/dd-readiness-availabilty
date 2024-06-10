package readiness.specificReadinessContexts.trainig;

import common.EventListener;
import readiness.ReadinessFacade;
import readiness.ReadinessUnitAdded;
import resourceCrud.ResourceType;

class ReadinessUnitAddedListener implements EventListener<ReadinessUnitAdded> {

    private final ReadinessFacade readinessFacade;

    ReadinessUnitAddedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(ReadinessUnitAdded event) {
        if (ResourceType.EMPLOYEE != event.resourceType()) {
            readinessFacade.readinessCheckPassedBy(event.resourceId(), TrainingReadinessContextId.VALUE);
        }
    }
}
