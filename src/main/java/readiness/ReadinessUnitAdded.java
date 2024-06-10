package readiness;

import common.Event;
import common.ResourceId;
import resourceCrud.ResourceType;

public record ReadinessUnitAdded(
        ResourceId resourceId,
        ResourceType resourceType
) implements Event {
}
