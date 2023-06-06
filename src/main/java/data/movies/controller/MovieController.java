package data.movies.controller;

import data.movies.entities.Actor;
import data.movies.entities.Movie;
import data.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Void> createMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/mongodb")
    public ResponseEntity<List<Movie>> getAllMoviesFromMongoDB() {
        System.out.println("hai");
        List<Movie> movies = movieService.getAllMoviesFromMongoDB();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/mongodb/{id}")
    public ResponseEntity<Movie> getMovieByIdFromMongoDB(@PathVariable String id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return movie.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/es/{search_name}")
    public ResponseEntity<List<Movie>> getMoviesBySearch(@PathVariable String search_name){
        List<Movie> mvis = movieService.search(search_name);
        return new ResponseEntity<>(mvis, HttpStatus.OK);
    }

}
