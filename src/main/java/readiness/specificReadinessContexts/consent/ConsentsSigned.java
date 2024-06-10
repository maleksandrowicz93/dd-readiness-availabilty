package readiness.specificReadinessContexts.consent;

import common.Event;
import publishedLanguage.ResourceId;

public record ConsentsSigned(ResourceId resourceId) implements Event {
}
