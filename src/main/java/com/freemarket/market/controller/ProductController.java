package com.freemarket.market.controller;

import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.freemarket.market.models.Product;
import com.freemarket.market.services.ElasticSearchService;
import com.freemarket.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping("/getProducts")
    public Iterable<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product p){
        productService.addProduct(p);
    }

    @GetMapping("/autoSuggest/{partialProductName}")
    public List<Product> autoSuggestProduct(@PathVariable String partialProductName){
        return productService.getSuggest(partialProductName);
    }
}
