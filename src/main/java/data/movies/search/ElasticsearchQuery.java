
package data.movies.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregate;
import co.elastic.clients.elasticsearch._types.aggregations.StringTermsBucket;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.movies.entities.Cast;
import jakarta.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ElasticsearchQuery{
    private final ElasticsearchClient client;

    @Autowired
    public ElasticsearchQuery(ElasticsearchClient client) {
        this.client = client;
    }

    public List<List<Cast>>getCastFromResponse(SearchResponse<Void> response, String agg1Name, String agg2Name) throws IOException{
        List<List<Cast>> commonMovieCasts = new ArrayList<>();

        List<StringTermsBucket> buckets = response.aggregations().get(agg1Name).sterms().buckets().array();

        for(StringTermsBucket bucket:buckets){
            List<Aggregate> aggs = bucket.aggregations().values().stream().toList();
            List<Cast> cast = new ArrayList<>();
            for(Aggregate agg:aggs){
                List<Hit<JsonData>> hits = agg.topHits().hits().hits();
                for(Hit<JsonData> hit:hits){
                    JsonObject json = hit.source().toJson().asJsonObject();
                    ObjectMapper objectMapper = new ObjectMapper();
                    Cast cst = objectMapper.readValue(json.toString(), new TypeReference<Cast>() {
                    });
                    cast.add(cst);
                }
            }
            commonMovieCasts.add(cast);
        }
        return commonMovieCasts;
    }

    public List<List<Cast>> getCommonActorCasts(List<String> actorIds) throws IOException {
        Query query1 = MatchQuery.of(m -> m
                .field("actor_id")
                .query(actorIds.toString())
        )._toQuery();

        int num_actors = actorIds.size();

        SearchResponse<Void> response = client.search(b -> b
                        .index("castesd")
                        .size(0)
                        .query(query1)
                        .aggregations("movie-buckets", a->a
                                .terms(f->f
                                        .field("movie_id.keyword")
                                        .minDocCount(num_actors)
                                )
                                .aggregations("matches", c->c
                                        .topHits(v->v.size(num_actors))
                                )
                        )
                ,
                Void.class
        );
        return getCastFromResponse(response,"movie-buckets", "matches");
    }

    public List<List<Cast>> getCommonMovieCasts(List<String> movieIds) throws IOException {
        Query query1 = MatchQuery.of(m -> m
                .field("movie_id")
                .query(movieIds.toString())
        )._toQuery();

        int num_movies = movieIds.size();

        SearchResponse<Void> response = client.search(b -> b
                        .index("castesd")
                        .size(0)
                        .query(query1)
                        .aggregations("movie-buckets", a->a
                                .terms(f->f
                                        .field("actor_id")
                                        .minDocCount(num_movies)
                                )
                                .aggregations("matches", c->c
                                        .topHits(v->v.size(num_movies))
                                )
                        )
                ,
                Void.class
        );
        return getCastFromResponse(response,"movie-buckets", "matches");
    }


}