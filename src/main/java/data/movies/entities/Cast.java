package data.movies.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(indexName = "#{@environment.getProperty('elastic_cast_index_name')}")
@JsonIgnoreProperties(ignoreUnknown = true)
@org.springframework.data.mongodb.core.mapping.Document(collection = "#{@environment.getProperty('mongodb_cast_cluster_name')}")
@CompoundIndexes({
        @CompoundIndex(name = "unique_movie_actor", def = "{'movie_id' : 1, 'actor_id' : 1}", unique = true)
})
public class Cast {

    @Id
    private String id;
//    @Field(type = FieldType.Text,name = "actor_id")
//    @JsonProperty("actor_id")
//    @org.springframework.data.mongodb.core.mapping.Field("actor_id")
//    @DBRef
    @JsonProperty("actor_id")
    @Field(type =FieldType.Text, name = "actor_id")
    @org.springframework.data.mongodb.core.mapping.Field("actor_id")
    private String actorId;

    private String character;

    @Field(name = "movie_id")
    @JsonProperty("movie_id")
    @org.springframework.data.mongodb.core.mapping.Field("movie_id")
    private String movieId;


    @Field(name = "actor_name")
    @JsonProperty("actor_name")
    @org.springframework.data.mongodb.core.mapping.Field("actor_name")
    private String actorName;

    public Cast(){
    }

    public Cast(String actorId, String character, String movieId, String actorName) {
        this.actorId = actorId;
        this.character = character;
        this.movieId = movieId;
        this.actorName = actorName;
    }

    // Getters and setters

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
}
