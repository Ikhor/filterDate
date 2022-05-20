package com.akrios.domain;

import java.math.BigDecimal;

//Item: information about the purchased item (cost, shipping fee, tax amount, ...)
// These entities are all related: one order contains several items and each item has a product.
public class Item {

    //double or float are not recommended, since they always carry small rounding differences
    private BigDecimal cost;
    private BigDecimal shippingFee;
    private BigDecimal taxAmount;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }
}
