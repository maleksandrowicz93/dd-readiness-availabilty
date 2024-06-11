package readiness.specificReadinessContexts.trainig;

import domainInfra.ResourceEvent;
import publishedLanguage.ResourceId;

public record TrainingsPassed(ResourceId resourceId) implements ResourceEvent {
}
