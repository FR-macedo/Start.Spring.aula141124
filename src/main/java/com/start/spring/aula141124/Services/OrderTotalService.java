package com.start.spring.aula141124.Services;

import com.start.spring.aula141124.Entities.Order;
import com.start.spring.aula141124.Entities.Product;

public class OrderTotalService {
    public double calculateOrderTotal(Order order) {
        double total = 0;
        for (Product product : order.getProductList()) {
            total += product.getPrice();
        }
        return total;
    }
}
