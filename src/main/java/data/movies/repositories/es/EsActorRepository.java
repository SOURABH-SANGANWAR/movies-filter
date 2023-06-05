package data.movies.repositories.es;

import data.movies.entities.Actor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsActorRepository extends ElasticsearchRepository<Actor, String> {
}
