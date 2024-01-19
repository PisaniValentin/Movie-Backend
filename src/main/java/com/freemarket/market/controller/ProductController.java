package com.freemarket.market.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.freemarket.market.models.Product;
import com.freemarket.market.services.ElasticSearchService;
import com.freemarket.market.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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
    public List<String> autoSuggestProduct(@PathVariable String partialProductName){
        try {
            SearchResponse<Product> searchResponse = elasticSearchService.autoSuggestProduct(partialProductName);
            List<Hit<Product>> hitList = searchResponse.hits().hits();
            List<Product> productList = new ArrayList<>();
            for(Hit<Product> hit : hitList){
                productList.add(hit.source());
            }
            List<String> listOfProductNames = new ArrayList<>();
            for(Product product : productList){
                listOfProductNames.add(product.getName());
            }
            return listOfProductNames;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
