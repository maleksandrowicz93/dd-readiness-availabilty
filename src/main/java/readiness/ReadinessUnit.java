package readiness;

import publishedLanguage.ResourceId;

import java.util.Collection;
import java.util.HashSet;

class ReadinessUnit {

    private final ResourceId resourceId;
    private final Collection<ReadinessContextId> awaitingReadinessChecks = new HashSet<>();
    private boolean isReady = false;

    ReadinessUnit(ResourceId resourceId, Collection<ReadinessContextId> awaitingReadinessChecks) {
        this.resourceId = resourceId;
        this.awaitingReadinessChecks.addAll(awaitingReadinessChecks);
    }

    void removeReadinessLock(ReadinessContextId lock) {
        if (!awaitingReadinessChecks.contains(lock)) {
            return;
        }
        awaitingReadinessChecks.remove(lock);
        if (awaitingReadinessChecks.isEmpty()) {
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
