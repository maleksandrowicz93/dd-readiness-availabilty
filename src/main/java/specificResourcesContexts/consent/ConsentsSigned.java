package specificResourcesContexts.consent;

import common.Event;
import common.ResourceId;

public record ConsentsSigned(ResourceId resourceId) implements Event {
}
