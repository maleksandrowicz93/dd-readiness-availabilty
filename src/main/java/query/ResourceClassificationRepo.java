package query;

import publishedLanguage.ResourceId;

import java.util.Optional;

public interface ResourceClassificationRepo {

    Optional<ResourceClassification> findById(ResourceId resourceId);
}
