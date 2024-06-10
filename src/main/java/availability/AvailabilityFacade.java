package availability;

import publishedLanguage.ResourceId;

public class AvailabilityFacade {

    private final AvailabilityRepo availabilityRepo;

    AvailabilityFacade(AvailabilityRepo availabilityRepo) {
        this.availabilityRepo = availabilityRepo;
    }

    public void addAvailabilityUnitFor(ResourceId resourceId) {
        var unit = new AvailabilityUnit(resourceId);
        availabilityRepo.save(unit);
    }
}
