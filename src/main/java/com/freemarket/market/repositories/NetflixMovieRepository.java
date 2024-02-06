package com.freemarket.market.repositories;

import com.freemarket.market.models.NetflixMovie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface NetflixMovieRepository extends ElasticsearchRepository<NetflixMovie, String> {
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
