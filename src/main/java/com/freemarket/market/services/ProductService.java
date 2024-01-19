package com.freemarket.market.services;

import com.freemarket.market.models.Product;
import com.freemarket.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product p){
        productRepository.save(p);
    }

    public void removeProduct(int id){
        productRepository.deleteById(id);
    }

    public void editProduct(Product p,int id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            product.get().setDescription(p.getDescription());
            product.get().setPrice(p.getPrice());
            product.get().setQuantity(p.getQuantity());
            product.get().setName(p.getName());
        }
    }
}
