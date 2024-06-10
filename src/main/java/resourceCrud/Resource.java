package resourceCrud;

import common.ResourceId;

import java.util.Collection;

record Resource(
        ResourceId resourceId,
        String name,
        ResourceType resourceType,
        Collection<String> capabilities
) {
}
