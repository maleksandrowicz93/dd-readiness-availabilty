package readiness.specificReadinessContexts.trainig;

import common.EventListener;
import readiness.ReadinessFacade;

class TrainingsPassedListener implements EventListener<TrainingsPassed> {

    private final ReadinessFacade readinessFacade;

    TrainingsPassedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(TrainingsPassed event) {
        readinessFacade.readinessCheckPassedBy(event.resourceId(), TrainingReadinessContextId.VALUE);
    }
}
