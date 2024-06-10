package readiness;

import readiness.specificReadinessContexts.consent.ConsentReadinessContextId;
import readiness.specificReadinessContexts.trainig.TrainingReadinessContextId;

import java.util.Collection;
import java.util.Set;

class SpecificReadinessContextIdFactory {

    Collection<ReadinessContextId> createAll() {
        return Set.of(
                ConsentReadinessContextId.VALUE,
                TrainingReadinessContextId.VALUE
        );
    }
}
