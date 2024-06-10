package availability;

import common.ResourceId;

class AvailabilityUnit {

    private final ResourceId resourceId;
    private boolean isAvailable = true;

    AvailabilityUnit(ResourceId resourceId) {
        this.resourceId = resourceId;
    }

    void block() {
        isAvailable = false;
    }

    void release() {
        isAvailable = true;
    }

    ResourceId resourceId() {
        return resourceId;
    }
}
