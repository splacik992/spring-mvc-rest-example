package com.example.springmvcrest.repositories;

import com.example.springmvcrest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerById(Long id);
    Optional<Customer> findById(Long id);

}
