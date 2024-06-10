package resourceCrud;

import common.EventPublisher;
import common.ResourceId;
import readiness.ReadinessFacade;

import java.util.Collection;
import java.util.UUID;

public class ResourceCrudFacade {

    private final EventPublisher eventPublisher;
    private final ResourceRepo resourceRepo;
    private final ReadinessFacade readinessFacade;

    ResourceCrudFacade(EventPublisher eventPublisher, ResourceRepo resourceRepo, ReadinessFacade readinessFacade) {
        this.eventPublisher = eventPublisher;
        this.resourceRepo = resourceRepo;
        this.readinessFacade = readinessFacade;
    }

    public void addResource(String name, ResourceType resourceType, Collection<String> capabilities) {
        var resource = new Resource(new ResourceId(UUID.randomUUID()), name, resourceType, capabilities);
        resourceRepo.save(resource);
        readinessFacade.addReadinessUnit(resource.resourceId());
        eventPublisher.publish(new ResourceAdded(resource.resourceId(), resourceType));
    }
}
