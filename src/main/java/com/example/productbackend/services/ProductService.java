package com.example.productbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productbackend.entities.Product;
import com.example.productbackend.repositories.ProductRepository;

@Service
public class ProductService {
    

    @Autowired
    private ProductRepository repository;


    public List<Product> getProducts(){
        return this.repository.findAll();
        
    }

}
