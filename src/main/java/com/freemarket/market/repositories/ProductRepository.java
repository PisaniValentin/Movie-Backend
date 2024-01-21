package com.freemarket.market.repositories;

import com.freemarket.market.models.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {
    public List<Product> findByNameOrderByIdAsc(String name);
}
