package readiness;

import domainInfra.ResourceEvent;
import readiness.specificReadinessContexts.certificate.CertificateConfirmed;
import readiness.specificReadinessContexts.consent.ConsentsSigned;
import readiness.specificReadinessContexts.liabilityAsusrance.LiabilityAssuranceSigned;
import readiness.specificReadinessContexts.trainig.TrainingsPassed;

record ReadinessContextId(String value) {

    static ReadinessContextId certificateConfirmed() {
        return new ReadinessContextId("CERTIFICATE_CONFIRMED");
    }

    static ReadinessContextId consentsSigned() {
        return new ReadinessContextId("CONSENTS_SIGNED");
    }

    static ReadinessContextId liabilityAssuranceSigned() {
        return new ReadinessContextId("LIABILITY_ASSURANCE_SIGNED");
    }

    static ReadinessContextId trainingsPassed() {
        return new ReadinessContextId("TRAININGS_PASSED");
    }

    static ReadinessContextId from(ResourceEvent event) {
        return switch (event) {
            case CertificateConfirmed _ -> certificateConfirmed();
            case ConsentsSigned _ -> consentsSigned();
            case LiabilityAssuranceSigned _ -> liabilityAssuranceSigned();
            case TrainingsPassed _ -> trainingsPassed();
            default -> throw new IllegalStateException("Unexpected value: " + event);
        };
    }
}

