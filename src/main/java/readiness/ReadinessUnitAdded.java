package readiness;

import common.Event;
import publishedLanguage.ResourceId;
import publishedLanguage.ResourceType;

public record ReadinessUnitAdded(
        ResourceId resourceId,
        ResourceType resourceType
) implements Event {
}
