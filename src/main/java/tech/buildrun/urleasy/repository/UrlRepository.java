package tech.buildrun.urleasy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.buildrun.urleasy.entities.UrlEntity;

@Repository
public interface UrlRepository extends MongoRepository<UrlEntity, String> {
}
