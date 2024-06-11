package readiness;

import availability.AvailabilityFacade;
import domainInfra.ResourceEvent;
import publishedLanguage.ResourceId;
import query.ResourceClassificationRepo;

public class ReadinessFacade {

    private final ReadinessRepo readinessRepo;
    private final ResourceClassificationRepo resourceClassificationRepo;
    private final AvailabilityFacade availabilityFacade;

    ReadinessFacade(
            ReadinessRepo readinessRepo,
            ResourceClassificationRepo resourceClassificationRepo,
            AvailabilityFacade availabilityFacade
    ) {
        this.readinessRepo = readinessRepo;
        this.resourceClassificationRepo = resourceClassificationRepo;
        this.availabilityFacade = availabilityFacade;
    }

    public void addReadinessUnit(ResourceId resourceId) {
        resourceClassificationRepo.findById(resourceId)
                                  .ifPresent(resourceClassification -> {
                                      var factory = new AwaitingReadinessChecksFactory();
                                      var awaitingReadinessChecks = factory.createFor(resourceClassification);
                                      var unit = new ReadinessUnit(resourceId, awaitingReadinessChecks);
                                      readinessRepo.save(unit);
                                      if (unit.isReady()) {
                                          availabilityFacade.addAvailabilityUnitFor(resourceId);
                                      }
                                  });
    }

    public void readinessCheckPassedBy(ResourceEvent event) {
        readinessRepo.findByResourceId(event.resourceId())
                     .ifPresent(unit -> {
                         unit.removeReadinessLock(ReadinessContextId.from(event));
                         if (unit.isReady()) {
                             availabilityFacade.addAvailabilityUnitFor(event.resourceId());
                         }
                     });
    }
}
