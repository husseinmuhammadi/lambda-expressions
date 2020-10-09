package com.javastudio.tutorial.repository;

import com.javastudio.tutorial.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

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
}
