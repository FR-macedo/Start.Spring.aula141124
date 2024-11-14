package com.start.spring.aula141124.Repository;

import com.start.spring.aula141124.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}