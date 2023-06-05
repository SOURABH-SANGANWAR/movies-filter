package data.movies.repositories.es;

import data.movies.entities.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsMovieRepository extends ElasticsearchRepository<Movie, String> {
    // You can add custom methods here if needed
}
