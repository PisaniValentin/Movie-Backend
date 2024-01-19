package com.freemarket.market.services;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.freemarket.market.models.Product;
import com.freemarket.market.utils.ElasticSearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.Supplier;

@Service
public class ElasticSearchService {
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public SearchResponse<Product> autoSuggestProduct(String partialProductName) throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.createSupplierAutoSuggest(partialProductName);
        SearchResponse<Product> searchResponse =
                elasticsearchClient
                        .search(s-> s.index("products").query(supplier.get()),Product.class);
        System.out.println("elastic search:"+ supplier.get().toString());
        return searchResponse;
    }
}
