package com.javastudio.tutorial.service;

import com.javastudio.tutorial.model.Product;
import com.javastudio.tutorial.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private final ProductRepository REPOSITORY;

    public ProductService(ProductRepository REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    public List<Product> findAll() {
        return REPOSITORY.findAll();
    }

    public List<Product> findByName(String name) {
        return REPOSITORY.findAll()
                .stream().filter(
                        p -> p.getName().contains(name)
                ).collect(Collectors.toList());
    }
}
