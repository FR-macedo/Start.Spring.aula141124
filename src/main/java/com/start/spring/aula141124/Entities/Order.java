package com.start.spring.aula141124.Entities;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Order {
    private Long id;
    private List<Product> productList;
    private double total;

    public Order(Long id, List<Product> productList, double total) {
        this.id = id;
        this.productList = productList;
        this.total = total;
    }



    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productList=" + productList +
                ", total=" + total +
                '}';
    }
}
