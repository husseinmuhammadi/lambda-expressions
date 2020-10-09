package com.javastudio.tutorial;

import com.javastudio.tutorial.model.Product;
import com.javastudio.tutorial.repository.ProductRepository;
import com.javastudio.tutorial.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private static final ProductRepository REPOSITORY = new ProductRepository();
    private static final ProductService SERVICE = new ProductService(REPOSITORY);

    public static void main(String[] args) {
        LOGGER.info("Application started!");
        try {
            LOGGER.info("Get all products");
            List<Product> products = SERVICE.findAll();
            products.stream().map(Product::toString).forEach(LOGGER::info);
            LOGGER.info("Sort the products");
            Collections.sort(products, Comparator.comparing(Product::getName));
            products.stream().map(Product::toString).forEach(LOGGER::info);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
