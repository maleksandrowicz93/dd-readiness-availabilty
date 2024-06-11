package domainInfra;

import infra.Event;
import publishedLanguage.ResourceId;

public interface ResourceEvent extends Event {

    ResourceId resourceId();
}
