
package data.movies.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Document(indexName = "movies_index_test")
@org.springframework.data.mongodb.core.mapping.Document(collection = "movies_mongo_final_test")
public class Movie {
    @Id
    private String id;

    @Field(name = "belongs_to_collection")
    @JsonProperty("belongs_to_collection")
    @org.springframework.data.mongodb.core.mapping.Field("belongs_to_collection")
    private int belongsToCollection;


    private boolean adult;
    private String budget;
    private List<String> genres;
    private String homepage;

    @Field(name = "imdb_id")
    @JsonProperty("imdb_id")
    @org.springframework.data.mongodb.core.mapping.Field("imdb_id")
    private String imdbId;


    @Field("original_language")
    @JsonProperty("original_language")
    @org.springframework.data.mongodb.core.mapping.Field("original_language")
    private String originalLanguage;


    private String overview;

    private double popularity;

    @Field("poster_path")
    @JsonProperty("poster_path")
    @org.springframework.data.mongodb.core.mapping.Field("poster_path")
    private String posterPath;

    @Field("production_companies")
    @JsonProperty("production_companies")
    @org.springframework.data.mongodb.core.mapping.Field("production_companies")
    private List<String> productionCompanies;

    @Field("production_countries")
    @JsonProperty("production_countries")
    @org.springframework.data.mongodb.core.mapping.Field("production_countries")
    private List<String> productionCountries;

    @Field("release_date")
    @JsonProperty("release_date")
    @org.springframework.data.mongodb.core.mapping.Field("release_date")
    private String releaseDate;

    private long revenue;
    private float runtime;

    @Field("spoken_languages")
    @JsonProperty("spoken_languages")
    @org.springframework.data.mongodb.core.mapping.Field("spoken_languages")
    private List<String> spokenLanguages;

    private String status;
    private String tagline;
    private String title;
    private boolean video;

    @Field("vote_average")
    @JsonProperty("vote_average")
    @org.springframework.data.mongodb.core.mapping.Field("vote_average")
    private double voteAverage;

    @Field("vote_count")
    @JsonProperty("vote_count")
    @org.springframework.data.mongodb.core.mapping.Field("vote_count")
    private long voteCount;

    public Movie() {
    }

    public Movie(String id, int belongsToCollection, boolean adult, String budget, List<String> genres,
                 String homepage, String imdbId, String originalLanguage, String overview, double popularity,
                 String posterPath, List<String> productionCompanies, List<String> productionCountries,
                 String releaseDate, long revenue, float runtime, List<String> spokenLanguages, String status,
                 String tagline, String title, boolean video, double voteAverage, long voteCount) {
        this.id = id;
        this.belongsToCollection = belongsToCollection;
        this.adult = adult;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBelongsToCollection() {
        return belongsToCollection;
    }

    public void setBelongsToCollection(int belongsToCollection) {
        this.belongsToCollection = belongsToCollection;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<String> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<String> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<String> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<String> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public float getRuntime() {
        return runtime;
    }

    public void setRuntime(float runtime) {
        this.runtime = runtime;
    }

    public List<String> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<String> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(long voteCount) {
        this.voteCount = voteCount;
    }
}
