package query;

import publishedLanguage.Capability;
import publishedLanguage.ResourceId;
import publishedLanguage.ResourceType;

import java.util.Collection;

public record ResourceClassification(
        ResourceId resourceId,
        ResourceType resourceType,
        Collection<Capability> capabilities
) {
}
