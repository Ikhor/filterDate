package com.akrios;

// Implement a tool that receives an interval and filters all orders placed during that interval.
//
// The result should be a list of intervals (in months) that groups the orders based on the product age (creation date field in the product entity).
// If we have orders in the older intervals, it means that older products are still being sold.

// Bonus feature:
// Add an argument to this tool that allow to pass a list of intervals instead of having the fixed intervals defined (“1-3”, “4-6”, “7-12”, “>12”)

import com.akrios.domain.Item;
import com.akrios.domain.Order;
import com.akrios.domain.Product;
import com.akrios.utils.Utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.System.exit;

// http://www.javapractices.com/topic/TopicAction.do?Id=13
public class Main {

    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Invalid arguments length");
            exit(1);
        }

        LocalDateTime ldt = LocalDateTime
                .parse(args[0], formatter);
        ZonedDateTime zdtBegin = ZonedDateTime.of(ldt, ZoneId.systemDefault());
        System.out.println(zdtBegin);

        ldt = LocalDateTime
                .parse(args[1], formatter);
        ZonedDateTime zdtEnd = ZonedDateTime.of(ldt, ZoneId.systemDefault());
        System.out.println(zdtEnd);

        // Todo Bonus feature: Add an argument to this tool that allow to pass a list of intervals instead of having the fixed intervals defined (“1-3”, “4-6”, “7-12”, “>12”)
//        for (String arg : args) {
//
//        }

        List<Product> productList = Utils.populateProduct();
        List<Item> itemList = Utils.populateItem(productList);
        List<Order> orderList = Utils.populateOrder(itemList);

        System.out.println("Result:");

        System.out.println("1-3 months: " + filter(zdtBegin,1, zdtEnd,3, orderList) + " orders");
        System.out.println("4-6 months: " + filter(zdtBegin,4, zdtEnd,6, orderList) + " orders");
        System.out.println("7-12 months: " + filter(zdtBegin,7, zdtEnd,12, orderList) + " orders");
        System.out.println(">12 months: " + filter(zdtBegin,12, zdtEnd,Utils.maxMonthsDiff, orderList) + " orders");
    }

    public static int filter(ZonedDateTime zdtBegin, int intervalBegin, ZonedDateTime zdtEnd, int intervalEnd, List<Order> orderList){
        int count = 0;
        boolean canCount;
        for (Order o: orderList) {
            canCount = true;
            for(Item i: o.getItemList()) {
                ZonedDateTime creationDate = i.getProduct().getCreationDate();
                if (canCount
                        && creationDate.isBefore(zdtEnd.minusMonths(intervalBegin))
                        && creationDate.isAfter(zdtBegin.minusMonths(intervalEnd))){
                    count++;
                    canCount = false;
                }
            }
        }
        return count;
    }
}
