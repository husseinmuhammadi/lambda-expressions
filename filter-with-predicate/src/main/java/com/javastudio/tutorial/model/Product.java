package com.javastudio.tutorial.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Product {

    private static final Logger LOGGER = LoggerFactory.getLogger(Product.class);

    String name; // required
    Date expirationDate; // optional
    Date orderDate; // optional
    double price; // optional

    private Product(Builder builder) {
        this.name = builder.name;
        this.expirationDate = builder.expirationDate;
        this.orderDate = builder.orderDate;
        this.price = builder.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        return "";
    }

    public static class Builder {
        String name;
        Date expirationDate;
        Date orderDate;
        double price;

        public Builder(String name) {
            this.name = name;
        }

        public Builder expirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder orderDate(Date orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            Product product = new Product(this);
            validate(product);
            return product;
        }

        private void validate(Product product) {
            if (product.getPrice() < 0)
                throw new RuntimeException("Price could not be negative!");
        }
    }
}
