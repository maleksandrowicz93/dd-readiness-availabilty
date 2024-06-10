package resourceCrud;

import common.Event;
import publishedLanguage.ResourceId;
import publishedLanguage.ResourceType;

public record ResourceAdded(
        ResourceId resourceId,
        ResourceType resourceType
) implements Event {
}
