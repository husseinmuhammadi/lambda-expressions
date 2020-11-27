package com.javastudio.tutorial.lambda;

import com.javastudio.tutorial.lambda.model.Product;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class LambdaCollectionsTest {
    @Test
    void name() {
        LocalDateTime expiryDate = LocalDateTime.now();

        List<Product> products = Arrays.asList(
                new Product.Builder("Nail")
                        .expirationDate(
                                Date.from(LocalDateTime.of(2018, 8, 18, 4, 12).atZone(ZoneId.systemDefault()).toInstant())
                        ).build(),
                new Product.Builder("Nail")
                        .expirationDate(
                                Date.from(LocalDateTime.of(2020, 8, 18, 4, 12).atZone(ZoneId.systemDefault()).toInstant())
                        ).build(),
                new Product.Builder("Nail")
                        .expirationDate(
                                Date.from(LocalDateTime.of(2019, 8, 18, 4, 12).atZone(ZoneId.systemDefault()).toInstant())
                        ).build()
        );
    }
}