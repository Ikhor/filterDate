package com.akrios.domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

//Product: information about the product (name, category, weight, price, creation date, ...)
public class Product {

    private String name;

    // This should be an enum, but using as string for test
    private String category;

    //double or float are not recommended, since they always carry small rounding differences
    private BigDecimal weight;

    //double or float are not recommended, since they always carry small rounding differences
    private BigDecimal price;

    private ZonedDateTime creationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
