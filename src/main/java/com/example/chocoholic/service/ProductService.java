package com.example.chocoholic.service;

import com.example.chocoholic.model.Category;
import com.example.chocoholic.model.Product;
import com.example.chocoholic.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }


    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void removeProudctById(long id){
        productRepository.deleteById(id) ;
    }

    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProductsByCategory(int id){
       return productRepository.findAllByCategory_Id(id);
    }
}
