package com.start.spring.aula141124.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();
    private double total;

    public Order(Long id, List<Product> productList, double total) {
        this.id = id;
        this.productList = productList;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
