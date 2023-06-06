package data.movies.controller;

import data.movies.entities.Cast;
import data.movies.services.CastService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import data.movies.search.ElasticsearchQuery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cast API Routes", description = "CRUD and filers for cast.")
@RestController
@RequestMapping("/cast")
public class CastController {
    private final CastService castService;
    private final ElasticsearchQuery esQuery;

    @Autowired
    public CastController(CastService castService, ElasticsearchQuery esQuery) {
        this.castService = castService;
        this.esQuery = esQuery;
    }
//    @Autowired
//    public CastController(CastService castService) {
//        this.castService = castService;
//    }

    @PostMapping
    public ResponseEntity<Void> createCast(@RequestBody Cast cast) {
        castService.saveCast(cast);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/create-multiple/{movieId}")
    public ResponseEntity<Void> createMultipleCast(@PathVariable("movieId") String movieId, @RequestBody List<Cast> castList) {
        castService.saveCastsForMovieId(movieId, castList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Cast>> getMultipleMovieCast(@PathVariable("movieId") String movieId) {
        List<Cast> cast = castService.getCastByMovieId(movieId);
        return new ResponseEntity<>(cast, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cast>> getMultipleCast() {
        List<Cast> cast = castService.getAllCastFromMongoDB();
        return new ResponseEntity<>(cast, HttpStatus.OK);
    }

    @GetMapping("/actors/common")
    public ResponseEntity<List<List<Cast>>> getCommonActorsCast(@RequestBody List<String>actorIds) {

        System.out.println(actorIds);
        List<List<Cast>> casts = null;
        try {
            casts = esQuery.getCommonActorCasts(actorIds);
        } catch (IOException e) {
            casts = new ArrayList<>();
            System.out.println(e.toString());
            return new ResponseEntity<>(casts, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(casts, HttpStatus.OK);
    }

    @GetMapping("/movies/common")
    public ResponseEntity<List<List<Cast>>> getCommonMoviesCast(@RequestBody List<String>movieIds) {
        System.out.println(movieIds);
        List<List<Cast>> casts = null;
        try {
            casts = esQuery.getCommonMovieCasts(movieIds);
        } catch (IOException e) {
            casts = new ArrayList<>();
            System.out.println(e.toString());
            return new ResponseEntity<>(casts, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(casts, HttpStatus.OK);
    }






}
