package readiness;

import publishedLanguage.Capability;
import publishedLanguage.ResourceType;
import query.ResourceClassification;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

class AwaitingReadinessChecksFactory {

    Collection<ReadinessContextId> createFor(ResourceClassification resourceClassification) {
        var awaitingReadinessChecks = new HashSet<ReadinessContextId>();
        chooseProviderByResourceType(resourceClassification.resourceType())
                .map(AwaitingReadinessChecksProvider::provide)
                .ifPresent(awaitingReadinessChecks::addAll);
        resourceClassification.capabilities()
                              .stream()
                              .map(AwaitingReadinessChecksFactory::chooseProviderByCapability)
                              .flatMap(Optional::stream)
                              .filter(Objects::nonNull)
                              .map(AwaitingReadinessChecksProvider::provide)
                              .flatMap(Collection::stream)
                              .forEach(awaitingReadinessChecks::add);
        return Set.copyOf(awaitingReadinessChecks);
    }

    private static Optional<AwaitingReadinessChecksProvider> chooseProviderByResourceType(ResourceType resourceType) {
        return Optional.ofNullable(switch (resourceType) {
            case EMPLOYEE -> new ForEmployee();
            case SPACE -> new ForSpace();
            case null, default -> null;
        });
    }

    private static Optional<AwaitingReadinessChecksProvider> chooseProviderByCapability(Capability capability) {
        return Optional.ofNullable(switch (capability.type()) {
            case "VEHICLE" -> new ForVehicle();
            case "SKILL" -> new ForSKill();
            case null, default -> null;
        });
    }
}
