package com.example.springmvcrest.services;

import com.example.springmvcrest.api.v1.mapper.CustomerMapper;
import com.example.springmvcrest.api.v1.model.CustomerDTO;
import com.example.springmvcrest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO getCustomerByName(String name) {
        return customerMapper.customerToCustomerDTO(customerRepository.findByFirstName(name));
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }


}
