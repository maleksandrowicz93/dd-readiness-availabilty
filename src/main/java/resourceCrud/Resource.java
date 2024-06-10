package resourceCrud;

import publishedLanguage.ResourceId;
import publishedLanguage.ResourceType;

import java.util.Collection;

record Resource(
        ResourceId resourceId,
        String name,
        ResourceType resourceType,
        Collection<String> capabilities
) {
}
