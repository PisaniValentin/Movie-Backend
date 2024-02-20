package com.freemarket.movies.repositories;

import com.freemarket.movies.models.NetflixMovie;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface NetflixMovieRepository extends ElasticsearchRepository<NetflixMovie, String> {

    @Query("{\"match_phrase\": {\"title\": \"?0\"}}")
    public List<NetflixMovie> findByTitle(String title);

    public List<NetflixMovie> findByDescription(String description);

    //The method name above will be translated into the following Elasticsearch json query
    /**
     *
     * {
     *     "query": {
     *         "bool" : {
     *             "must" : [
     *                 { "query_string" : { "query" : "?", "fields" : [ "name" ] } },
     *                 { "query_string" : { "query" : "?", "fields" : [ "price" ] } }
     *             ]
     *         }
     *     }
     * }
     **/
}
