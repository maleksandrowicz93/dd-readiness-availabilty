package readiness;

import common.ResourceId;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class ReadinessUnit {

    private final ResourceId resourceId;
    private final Map<ReadinessContextId, Boolean> readinessChecks;
    private boolean isReady = false;

    ReadinessUnit(ResourceId resourceId, Collection<ReadinessContextId> readinessContexts) {
        this.resourceId = resourceId;
        this.readinessChecks = readinessContexts.stream()
                                                .collect(Collectors.toMap(
                                                        Function.identity(),
                                                        id -> false
                                                ));
    }

    void readinessCheckPassedBy(ReadinessContextId readinessContext) {
        if (!readinessChecks.containsKey(readinessContext)) {
            return;
        }
        readinessChecks.put(readinessContext, true);
        if (readinessChecks.values().stream().allMatch(Boolean.TRUE::equals)) {
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
