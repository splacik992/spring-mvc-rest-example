package com.example.springmvcrest.services;

import com.example.springmvcrest.api.v1.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerDTO getCustomerById(Long id);

    List<CustomerDTO> getAllCustomers();
}
