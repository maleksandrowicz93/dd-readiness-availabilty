package specificResourcesContexts.trainig;

import common.EventListener;
import readiness.ReadinessFacade;
import resourceCrud.ResourceAdded;
import resourceCrud.ResourceType;

class ResourceAddedListener implements EventListener<ResourceAdded> {

    private final ReadinessFacade readinessFacade;

    ResourceAddedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(ResourceAdded event) {
        if (ResourceType.EMPLOYEE == event.resourceType()) {
            readinessFacade.addLockFor(event.resourceId(), TrainingReadinessContextId.VALUE);
        }
    }
}
