package com.freemarket.market.utils;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

import java.util.function.Supplier;

public class ElasticSearchUtil {

    public static Supplier<Query> createSupplierAutoSuggest(String partialProductName){
        //Query.of to create a new Query instance
        Supplier<Query> supplier = ()->Query.of( q-> q.match(createAutoSuggestMatchQuery(partialProductName)));
        return supplier;
    }

    public static MatchQuery createAutoSuggestMatchQuery(String partialProductName){
        MatchQuery.Builder autoSuggestQuery = new MatchQuery.Builder();
        return autoSuggestQuery
                .field("name") //Field to match against.
                .query(partialProductName) //Specifies query text
                .analyzer("standard") //Specifies the analyzer used.
                .build();
    }
}
