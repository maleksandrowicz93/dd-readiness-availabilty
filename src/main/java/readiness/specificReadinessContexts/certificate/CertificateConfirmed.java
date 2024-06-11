package readiness.specificReadinessContexts.certificate;

import domainInfra.ResourceEvent;
import publishedLanguage.ResourceId;

public record CertificateConfirmed(ResourceId resourceId) implements ResourceEvent {
}
