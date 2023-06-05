package data.movies.services;

import data.movies.entities.Cast;
import data.movies.repositories.es.EsCastRepository;
import data.movies.repositories.mongo.MongoCastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CastService {
    private final EsCastRepository esCastRepository;
    private final MongoCastRepository mongoCastRepository;
    @Autowired
    public CastService(EsCastRepository esCastRepository, MongoCastRepository mongoCastRepository) {
        this.esCastRepository = esCastRepository;
        this.mongoCastRepository = mongoCastRepository;
    }




    public void saveCast(Cast cast) {
        mongoCastRepository.save(cast);
        esCastRepository.save(cast);
    }

    public List<Cast> getAllCastFromMongoDB() {
        return mongoCastRepository.findAll();
    }

    public Optional<Cast> getCastById(String id) {
        return mongoCastRepository.findById(id);
    }

    public List<Cast> getCastByMovieId(String movieId){
        return mongoCastRepository.findByMovieId(movieId);
    }

    public void saveCastsForMovieId(String movieId, List<Cast> casts) {
        casts.forEach(cast -> cast.setMovieId(movieId));
        mongoCastRepository.saveAll(casts);
        System.out.println("saved mongo");
        esCastRepository.saveAll(casts);
    }

//    public List<List<Cast>> getMoviesofActors(List<String>actorIds){
//        return [[]]
//    }
}
