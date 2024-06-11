package readiness;

import infra.EventListener;
import readiness.specificReadinessContexts.trainig.TrainingsPassed;

class TrainingsPassedListener implements EventListener<TrainingsPassed> {

    private final ReadinessFacade readinessFacade;

    TrainingsPassedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(TrainingsPassed event) {
        readinessFacade.readinessCheckPassedBy(event);
    }
}
