package readiness;

import infra.EventListener;
import readiness.specificReadinessContexts.certificate.CertificateConfirmed;

class CertificateConfirmedListener implements EventListener<CertificateConfirmed> {

    private final ReadinessFacade readinessFacade;

    CertificateConfirmedListener(ReadinessFacade readinessFacade) {
        this.readinessFacade = readinessFacade;
    }

    @Override
    public void handle(CertificateConfirmed event) {
        readinessFacade.readinessCheckPassedBy(event);
    }
}
