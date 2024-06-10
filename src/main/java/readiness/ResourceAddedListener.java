package readiness;

import common.EventListener;
import common.EventPublisher;
import resourceCrud.ResourceAdded;

class ResourceAddedListener implements EventListener<ResourceAdded> {

    private final ReadinessRepo readinessRepo;
    private final EventPublisher eventPublisher;

    ResourceAddedListener(ReadinessRepo readinessRepo, EventPublisher eventPublisher) {
        this.readinessRepo = readinessRepo;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void handle(ResourceAdded event) {
        var factory = new SpecificReadinessContextIdFactory();
        var unit = new ReadinessUnit(event.resourceId(), factory.createAll());
        readinessRepo.save(unit);
        eventPublisher.publish(new ReadinessUnitAdded(event.resourceId(), event.resourceType()));
    }
}
