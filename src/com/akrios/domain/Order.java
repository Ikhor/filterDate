package com.akrios.domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

// Order: contains general information about the order (customer name and contact, shipping address, grand total, date when the order was placed , ...)
// These entities are all related: one order contains several items and each item has a product.
public class Order {

    private String name;
    private String contact;
    private String shippingAddress;
    private BigDecimal grandTotal;
    private ZonedDateTime timestampOrder;

    private List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public ZonedDateTime getTimestampOrder() {
        return timestampOrder;
    }

    public void setTimestampOrder(ZonedDateTime timestampOrder) {
        this.timestampOrder = timestampOrder;
    }
}
