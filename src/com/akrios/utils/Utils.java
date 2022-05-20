package com.akrios.utils;

import com.akrios.domain.Item;
import com.akrios.domain.Order;
import com.akrios.domain.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;

public class Utils {

    public static int maxMonthsDiff = 13;
    private static int maxItemForOrder = 2;

    private static int maxProduct = 100;
    private static int maxItem = 40 ;
    private static int maxOrder = 4;

    private static Random generator = new Random();

    public static List<Product> populateProduct() {

        List<Product> productList = new ArrayList<>();

        for(int i = 0; i < maxProduct; i++) {
            Product p = new Product();
            p.setName("Product " + (i + 1));
            p.setCategory("Category " + (i%maxProduct)+1);
            p.setPrice(randomValue());
            int randomMonths = abs(generator.nextInt() % maxMonthsDiff);
            ZonedDateTime date = ZonedDateTime.now().minusMonths(randomMonths).minusDays(abs(generator.nextInt() % 30));

            p.setCreationDate(date);
            p.setWeight(randomValue());

            productList.add(p);
        }

//        System.out.println("====================PRINT Product Start===================");
//        for (Product p: productList) {
//            System.out.println(p.getName() + " " + p.getPrice());
//            System.out.println(p.getCreationDate());
//        }
//        System.out.println("====================PRINT Product End====================");
        return productList;
    }

    public static List<Item> populateItem(List<Product> productList) {

        List<Item> itemList = new ArrayList<>();

        for (int i =0; i < maxItem; i++) {
            int random = abs(generator.nextInt() % productList.size());
            Item item = new Item();
            item.setProduct(productList.get(random));
            item.setCost(randomValue());
            item.setTaxAmount(randomValue());
            item.setShippingFee(randomValue());

            itemList.add(item);
        }

//        System.out.println("====================PRINT Item Start===================");
//        for (Item i: itemList) {
//            System.out.println(i.getProduct().getName() + " " + i.getCost());
//        }
//        System.out.println("====================PRINT Item End====================");
        return itemList;
    }

    public static List<Order> populateOrder(List<Item> itemList) {

        List<Order> orderList  = new ArrayList<>();

        for(int i = 0; i < maxOrder; i++) {
            Order order = new Order();

            int random = abs(generator.nextInt() % maxMonthsDiff);

            order.setName("Name " + (i + 1));
            order.setContact("name" + (i + 1) + "@names.com");
            order.setShippingAddress("Address " + (i + 1));
            order.setTimestampOrder(ZonedDateTime.now().minusMonths(random));
            order.setGrandTotal(randomValue());
            order.setItemList(generateListItemForOrder(itemList));

            orderList.add(order);
        }

        System.out.println("====================PRINT Order Start===================");
        for (Order o: orderList) {
            System.out.println(o.getName());
            System.out.println("\t====================PRINT Item for Order Start==================");
            for (Item i: o.getItemList()) {
                System.out.println("\t\t" + i.getProduct().getName() + " " + i.getProduct().getCreationDate() );
            }
            System.out.println("\t====================PRINT Item for Order End====================");
        }
        System.out.println("====================PRINT Order End====================");
        return orderList;
    }

    private static List<Item> generateListItemForOrder(List<Item> itemList){

        List<Item> listForOrder = new ArrayList<>();
        for(int i = 0; i < maxItemForOrder; i++) {
            int randomItem = abs(generator.nextInt()%itemList.size());
            listForOrder.add(itemList.get(randomItem));
        }
        return listForOrder;
    }

    private static BigDecimal randomValue() {

        BigDecimal max = new BigDecimal(500);
        BigDecimal randFromDouble = BigDecimal.valueOf(Math.random());
        BigDecimal actualRandomDec = randFromDouble.multiply(max);
        actualRandomDec = actualRandomDec.setScale(2, RoundingMode.DOWN);
        return actualRandomDec;
    }
}
