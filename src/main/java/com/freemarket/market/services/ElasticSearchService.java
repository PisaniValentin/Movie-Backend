package com.freemarket.market.services;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.freemarket.market.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticSearchService {
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public SearchResponse<Product> autoSuggestProduct(String partialProductName) throws IOException {
        // Create a Supplier that supplies an Elasticsearch Query for auto-suggest
        //Supplier<Query> supplier = ElasticSearchUtil.createSupplierAutoSuggest(partialProductName);
        // Perform the Elasticsearch search using the Elasticsearch client
        //SearchResponse<Product> searchResponse =
               // elasticsearchClient
               //         .search(s-> s.index("products").query(supplier.get()),Product.class);
        // Return the SearchResponse containing the results


        //NativeQuery query = NativeQuery.builder()
        //        .



       // return searchResponse;
        return null;
    }
}
