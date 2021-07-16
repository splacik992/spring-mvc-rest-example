package com.example.springmvcrest.controllers.v1;

import com.example.springmvcrest.api.v1.model.CategoryListDTO;
import com.example.springmvcrest.api.v1.model.CustomerDTO;
import com.example.springmvcrest.api.v1.model.CustomerListDTO;
import com.example.springmvcrest.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping
    ResponseEntity<CustomerListDTO> getAllCustomers(){
        return new ResponseEntity<CustomerListDTO>(new CustomerListDTO(customerService.getAllCustomers()),HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    ResponseEntity<CustomerDTO> getCustomerByFirstName(@PathVariable Long id){

        return new ResponseEntity<CustomerDTO>(customerService.getCustomerById(id),HttpStatus.OK);
    }
}
