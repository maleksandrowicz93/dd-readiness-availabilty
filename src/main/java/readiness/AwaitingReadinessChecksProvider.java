package readiness;

import java.util.Collection;
import java.util.Set;

interface AwaitingReadinessChecksProvider {

    Collection<ReadinessContextId> provide();
}

class ForEmployee implements AwaitingReadinessChecksProvider {
    @Override
    public Collection<ReadinessContextId> provide() {
        return Set.of(
                ReadinessContextId.consentsSigned(),
                ReadinessContextId.trainingsPassed()
        );
    }
}

class ForSpace implements AwaitingReadinessChecksProvider {
    @Override
    public Collection<ReadinessContextId> provide() {
        return Set.of(
                ReadinessContextId.liabilityAssuranceSigned()
        );
    }
}

class ForSKill implements AwaitingReadinessChecksProvider {
    @Override
    public Collection<ReadinessContextId> provide() {
        return Set.of(
                ReadinessContextId.certificateConfirmed()
        );
    }
}

class ForVehicle implements AwaitingReadinessChecksProvider {
    @Override
    public Collection<ReadinessContextId> provide() {
        return Set.of(
                ReadinessContextId.liabilityAssuranceSigned()
        );
    }
}
