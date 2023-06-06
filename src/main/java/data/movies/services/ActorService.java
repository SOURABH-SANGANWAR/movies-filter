package data.movies.services;

import data.movies.entities.Actor;
import data.movies.entities.Movie;
import data.movies.repositories.es.EsActorRepository;
import data.movies.repositories.mongo.MongoActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private final EsActorRepository esActorRepository;
    private final MongoActorRepository mongoActorRepository;
    @Autowired
    public ActorService(EsActorRepository esActorRepository, MongoActorRepository mongoActorRepository) {
        this.esActorRepository = esActorRepository;
        this.mongoActorRepository = mongoActorRepository;
    }




    public void saveActor(Actor actor) {

        mongoActorRepository.save(actor);
        esActorRepository.save(actor);
    }

    public List<Actor> getAllActorsFromMongoDB() {
        return mongoActorRepository.findAll();
    }

    public Optional<Actor> getActorById(String id) {
        return mongoActorRepository.findById(id);
    }

    public void saveAllActors(List<Actor> actors){
        mongoActorRepository.saveAll(actors);
        esActorRepository.saveAll(actors);
    }

    public List<Actor> search(String searchText) {
        return esActorRepository.findByNameContains(searchText);

    }
}
