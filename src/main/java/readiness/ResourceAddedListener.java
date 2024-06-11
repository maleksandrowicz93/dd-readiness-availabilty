package readiness;

import infra.EventListener;
import resourceCrud.ResourceAdded;

class ResourceAddedListener implements EventListener<ResourceAdded> {

    private final ReadinessFacade readinessFacade;

    ResourceAddedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(ResourceAdded event) {
        readinessFacade.addReadinessUnit(event.resourceId());
    }
}
