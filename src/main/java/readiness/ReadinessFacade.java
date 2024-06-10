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

    public void addReadinessUnit(ResourceId resourceId) {
        var unit = new ReadinessUnit(resourceId);
        readinessRepo.save(unit);
    }

    public void addLockFor(ResourceId resourceId, ReadinessContextId readinessContextId) {
        readinessRepo.findByResourceId(resourceId)
                     .ifPresent(unit -> unit.addLock(readinessContextId));
    }

    public void removeLockFor(ResourceId resourceId, ReadinessContextId readinessContextId) {
        readinessRepo.findByResourceId(resourceId)
                     .ifPresent(unit -> {
                         unit.removeLock(readinessContextId);
                         if (unit.isReady()) {
                             availabilityFacade.addAvailabilityUnitFor(resourceId);
                         }
                     });
    }
}
