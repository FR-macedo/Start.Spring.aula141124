package com.start.spring.aula141124.Repository;

import com.start.spring.aula141124.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}