package readiness.specificReadinessContexts.liabilityAsusrance;

import domainInfra.ResourceEvent;
import publishedLanguage.ResourceId;

public record LiabilityAssuranceSigned(ResourceId resourceId) implements ResourceEvent {
}
