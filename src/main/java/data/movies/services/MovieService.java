package data.movies.services;

import data.movies.entities.Actor;
import data.movies.entities.Movie;
import data.movies.repositories.es.EsMovieRepository;
import data.movies.repositories.mongo.MongoMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final EsMovieRepository esMovieRepository;
    private final MongoMovieRepository mongoMovieRepository;

    @Autowired
    public MovieService(EsMovieRepository esMovieRepository, MongoMovieRepository mongoMovieRepository) {
        this.esMovieRepository = esMovieRepository;
        this.mongoMovieRepository = mongoMovieRepository;
    }

    public void saveMovie(Movie movie) {
        esMovieRepository.save(movie);
        mongoMovieRepository.save(movie);
    }

    public List<Movie> getAllMoviesFromMongoDB() {
        return mongoMovieRepository.findAll();
    }

    public Optional<Movie> getMovieById(String id) {
        return mongoMovieRepository.findById(id);
    }

    public List<Movie> search(String searchText) {
        return esMovieRepository.findByTitleContains(searchText);

    }
}
