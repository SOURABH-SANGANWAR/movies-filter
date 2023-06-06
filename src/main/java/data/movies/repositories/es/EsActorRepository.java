package data.movies.repositories.es;

import data.movies.entities.Actor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EsActorRepository extends ElasticsearchRepository<Actor, String> {
    List<Actor> findByNameContains(String searchText);
}
