package readiness;

import publishedLanguage.ResourceId;

import java.util.Optional;

interface ReadinessRepo {

    void save(ReadinessUnit readinessUnit);

    Optional<ReadinessUnit> findByResourceId(ResourceId resourceId);
}
