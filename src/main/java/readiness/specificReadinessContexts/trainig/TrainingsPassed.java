package readiness.specificReadinessContexts.trainig;

import common.Event;
import publishedLanguage.ResourceId;

public record TrainingsPassed(ResourceId resourceId) implements Event {
}
