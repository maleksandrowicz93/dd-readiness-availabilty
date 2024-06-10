package readiness.specificReadinessContexts.trainig;

import common.Event;
import common.ResourceId;

public record TrainingsPassed(ResourceId resourceId) implements Event {
}
