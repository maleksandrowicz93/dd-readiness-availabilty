package readiness;

import common.ResourceId;

import java.util.Collection;
import java.util.HashSet;

class ReadinessUnit {

    private final ResourceId resourceId;
    private final Collection<ReadinessContextId> locks = new HashSet<>();
    private boolean isReady = false;

    ReadinessUnit(ResourceId resourceId) {
        this.resourceId = resourceId;
    }

    void addLock(ReadinessContextId lock) {
        locks.add(lock);
    }

    void removeLock(ReadinessContextId lock) {
        if (!locks.contains(lock)) {
            return;
        }
        locks.remove(lock);
        if (locks.isEmpty()) {
            isReady = true;
        }
    }

    boolean isReady() {
        return isReady;
    }

    ResourceId resourceId() {
        return resourceId;
    }
}
