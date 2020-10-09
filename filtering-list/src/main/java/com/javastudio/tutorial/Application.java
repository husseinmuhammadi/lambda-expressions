package com.javastudio.tutorial;

import com.javastudio.tutorial.model.Product;
import com.javastudio.tutorial.repository.ProductRepository;
import com.javastudio.tutorial.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private static final ProductRepository REPOSITORY = new ProductRepository();
    private static final ProductService SERVICE = new ProductService(REPOSITORY);

    public static void main(String[] args) {
        LOGGER.info("Application started!");
        try {
            LOGGER.info("Find all products");
            SERVICE.findAll().stream().map(Product::toString).forEach(LOGGER::info);
            LOGGER.info("Find products which contains Wooden");
            SERVICE.findByName("Wooden").stream().map(Product::toString).forEach(LOGGER::info);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
