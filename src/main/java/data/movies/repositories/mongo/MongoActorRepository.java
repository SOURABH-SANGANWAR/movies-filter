package data.movies.repositories.mongo;

import data.movies.entities.Actor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoActorRepository extends MongoRepository<Actor,String>{
}
