package readiness.specificReadinessContexts.consent;

import domainInfra.ResourceEvent;
import publishedLanguage.ResourceId;

public record ConsentsSigned(ResourceId resourceId) implements ResourceEvent {
}
