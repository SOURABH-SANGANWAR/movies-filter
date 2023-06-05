package data.movies.repositories.mongo;

import data.movies.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoMovieRepository extends MongoRepository<Movie, String> {
    // You can add custom methods here if needed
}
