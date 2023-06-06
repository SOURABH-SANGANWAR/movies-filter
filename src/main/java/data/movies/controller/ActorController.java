package data.movies.controller;

import data.movies.entities.Actor;
import data.movies.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping
    public ResponseEntity<Void> createActor(@RequestBody Actor actor) {
        actorService.saveActor(actor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/create-multiple")
    public ResponseEntity<Void> createActormany(@RequestBody List<Actor> actors) {
        actorService.saveAllActors(actors);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/mongodb")
    public ResponseEntity<List<Actor>> getAllActorsFromMongoDB() {
        System.out.println("hai");
        List<Actor> actors = actorService.getAllActorsFromMongoDB();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    @GetMapping("/mongodb/{id}")
    public ResponseEntity<Actor> getMovieByIdFromMongoDB(@PathVariable String id) {
        Optional<Actor> actor = actorService.getActorById(id);
        return actor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/es/{search_name}")
    public ResponseEntity<List<Actor>> getActorBySearch(@PathVariable String search_name){
        List<Actor> acts = actorService.search(search_name);
        return new ResponseEntity<>(acts, HttpStatus.OK);
    }
}
