package resourceCrud;

import common.Event;
import common.ResourceId;

public record ResourceAdded(
        ResourceId resourceId,
        ResourceType resourceType
) implements Event {
}
