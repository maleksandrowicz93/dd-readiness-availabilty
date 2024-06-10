package readiness;

import availability.AvailabilityFacade;
import common.ResourceId;

public class ReadinessFacade {

    private final ReadinessRepo readinessRepo;
    private final AvailabilityFacade availabilityFacade;

    ReadinessFacade(ReadinessRepo readinessRepo, AvailabilityFacade availabilityFacade) {
        this.readinessRepo = readinessRepo;
        this.availabilityFacade = availabilityFacade;
    }

    public void readinessCheckPassedBy(ResourceId resourceId, ReadinessContextId readinessContextId) {
        readinessRepo.findByResourceId(resourceId)
                     .ifPresent(unit -> {
                         unit.readinessCheckPassedBy(readinessContextId);
                         if (unit.isReady()) {
                             availabilityFacade.addAvailabilityUnitFor(resourceId);
                         }
                     });
    }
}
