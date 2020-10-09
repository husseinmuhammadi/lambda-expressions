package com.javastudio.tutorial.service;

import com.javastudio.tutorial.model.Product;
import com.javastudio.tutorial.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceTest.class);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {
        ProductService service = new ProductService(new ProductRepository());
        List<Product> products = service.findAll();
        assertThat(products.size()).isGreaterThan(0);
    }

    @Test
    void findAllWithMockRepository() {
        ProductRepository repository = mock(ProductRepository.class);
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Product.Builder("Wooden chair").build(),
                new Product.Builder("Wooden drawer").build()
        ));
        ProductService service = new ProductService(repository);
        assertThat(service.findAll().size()).isEqualTo(2);
    }

    @Test
    void findByName() {
        ProductRepository repository = mock(ProductRepository.class);
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Product.Builder("Nail").price(10).build(),
                new Product.Builder("Wooden chair").price(850).build(),
                new Product.Builder("Wooden drawer").price(1000).build()
        ));
        ProductService service = new ProductService(repository);
        assertThat(service.findByName("Wood"))
                .extracting(product -> product.getPrice())
                .contains(850.0, 1000.0);
    }
}