package readiness;

import publishedLanguage.ResourceId;

import java.util.Collection;
import java.util.Set;

interface AwaitingReadinessChecksProvider {

    Collection<ReadinessContextId> provideFor(ResourceId resourceId);
}

class ForEmployee implements AwaitingReadinessChecksProvider {
    @Override
    public Collection<ReadinessContextId> provideFor(ResourceId resourceId) {
        return Set.of(
                ReadinessContextId.consentsSigned(),
                ReadinessContextId.trainingsPassed()
        );
    }
}

class ForSpace implements AwaitingReadinessChecksProvider {
    @Override
    public Collection<ReadinessContextId> provideFor(ResourceId resourceId) {
        return Set.of(
                ReadinessContextId.liabilityAssuranceSigned()
        );
    }
}

class ForSKill implements AwaitingReadinessChecksProvider {
    @Override
    public Collection<ReadinessContextId> provideFor(ResourceId resourceId) {
        return Set.of(
                ReadinessContextId.certificateConfirmed()
        );
    }
}

class ForVehicle implements AwaitingReadinessChecksProvider {
    @Override
    public Collection<ReadinessContextId> provideFor(ResourceId resourceId) {
        return Set.of(
                ReadinessContextId.liabilityAssuranceSigned()
        );
    }
}
