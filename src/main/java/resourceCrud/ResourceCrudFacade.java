package resourceCrud;

import common.EventPublisher;
import publishedLanguage.ResourceId;
import publishedLanguage.ResourceType;

import java.util.Collection;
import java.util.UUID;

public class ResourceCrudFacade {

    private final EventPublisher eventPublisher;
    private final ResourceRepo resourceRepo;

    ResourceCrudFacade(EventPublisher eventPublisher, ResourceRepo resourceRepo) {
        this.eventPublisher = eventPublisher;
        this.resourceRepo = resourceRepo;
    }

    public void addResource(String name, ResourceType resourceType, Collection<String> capabilities) {
        var resource = new Resource(new ResourceId(UUID.randomUUID()), name, resourceType, capabilities);
        resourceRepo.save(resource);
        eventPublisher.publish(new ResourceAdded(resource.resourceId(), resourceType));
    }
}
