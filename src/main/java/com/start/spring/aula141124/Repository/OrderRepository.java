package com.start.spring.aula141124.Repository;

import com.start.spring.aula141124.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}