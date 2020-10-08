package com.javastudio.tutorial.service;

import com.javastudio.tutorial.model.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private static final List<Product> PRODUCTS = Arrays.asList(
            new Product.Builder("Nail").build(),
            new Product.Builder("Hammer").price(1).build(),
            new Product.Builder("Basket").build(),
            new Product.Builder("Wooden chair").build(),
            new Product.Builder("Wooden drawer").build()
    );

    public List<Product> findAll() {
        return PRODUCTS;
    }

    public List<Product> findByName(String name) {
        return PRODUCTS
                .stream().filter(
                        p -> p.getName().contains(name)
                ).collect(Collectors.toList());
    }
}
