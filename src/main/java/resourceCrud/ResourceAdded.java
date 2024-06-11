package resourceCrud;

import domainInfra.ResourceEvent;
import publishedLanguage.ResourceId;

public record ResourceAdded(
        ResourceId resourceId
) implements ResourceEvent {
}
