package data.movies.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@Document(indexName = "actors_final")
@Document(indexName = "#{@environment.getProperty('elastic_actor_index_name')}")
@org.springframework.data.mongodb.core.mapping.Document(collection = "#{@environment.getProperty('mongodb_actor_cluster_name')}")
public class Actor {
    @Id
    private String id;

    private int gender;
    private String name;

    @Field(name = "profile_path")
    @JsonProperty("profile_path")
    @org.springframework.data.mongodb.core.mapping.Field("profile_path")
    private String profilePath;

    public Actor(){
    }

    public Actor(String id, int gender, String name, String profilePath) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.profilePath = profilePath;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }
}
