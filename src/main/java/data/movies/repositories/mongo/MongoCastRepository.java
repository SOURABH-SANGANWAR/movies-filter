package data.movies.repositories.mongo;

import data.movies.entities.Cast;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoCastRepository extends MongoRepository<Cast, String> {
    List<Cast> findByMovieId(String movieId);
}
