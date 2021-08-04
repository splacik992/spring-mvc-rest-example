package com.example.springmvcrest.services;

import com.example.springmvcrest.api.v1.mapper.CustomerMapper;
import com.example.springmvcrest.api.v1.model.CustomerDTO;
import com.example.springmvcrest.bootstrap.Bootstrap;
import com.example.springmvcrest.domain.Customer;
import com.example.springmvcrest.repositories.CategoryRepository;
import com.example.springmvcrest.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerServiceImplT {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {

        System.out.println("Loading Customer Data");
        System.out.println(customerRepository.findAll().size());

        Bootstrap bootstrap = new Bootstrap(categoryRepository,customerRepository);
        bootstrap.run();

        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);

    }

    @Test
    public void patchCustomerUpdateFirstName(){

    }
    @Test
    public void patchCustomerUpdateLastName() {
        String updatedName = "UpdatedName";
        long id = getCustomersId();

        Customer originalCustomer = customerRepository.getById(id);
        assertNotNull(originalCustomer);

        //save original first/last name;
        String originalName = originalCustomer.getFirstName();
        String originalLastName = originalCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(updatedName);

        customerService.patchCustomer(id,customerDTO);

        Customer updatedCustomer = customerRepository.findCustomerById(id);

        assertNotNull(updatedCustomer);
        assertEquals(updatedName,updatedCustomer.getFirstName());
        assertNotSame(originalName,updatedCustomer.getFirstName());
        assertNotSame(originalLastName,updatedCustomer.getLastName());

    }

    private Long getCustomersId(){
        List<Customer> customers = customerRepository.findAll();

        System.out.println("Customers found: " + customers.size());

        return customers.get(0).getId();
    }
}
