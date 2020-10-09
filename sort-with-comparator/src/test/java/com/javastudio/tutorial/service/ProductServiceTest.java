package com.javastudio.tutorial.service;

import com.javastudio.tutorial.model.Product;
import com.javastudio.tutorial.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceTest.class);

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductService service;

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
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Product.Builder("Wooden chair").build(),
                new Product.Builder("Wooden drawer").build()
        ));
        assertThat(service.findAll().size()).isEqualTo(2);
    }
}