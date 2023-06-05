package data.movies.repositories.es;

import data.movies.entities.Cast;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsCastRepository extends ElasticsearchRepository<Cast, String> {
}
