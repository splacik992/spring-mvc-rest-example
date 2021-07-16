package com.example.springmvcrest.bootstrap;

import com.example.springmvcrest.domain.Category;
import com.example.springmvcrest.domain.Customer;
import com.example.springmvcrest.repositories.CategoryRepository;
import com.example.springmvcrest.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategory();
        loadCustomers();
    }




    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setFirstName("Jan");
        customer1.setLastName("Kowalski");

        Customer customer2 = new Customer();
        customer2.setFirstName("Maria");
        customer2.setLastName("Waniewska");

        Customer customer3 = new Customer();
        customer3.setFirstName("Piotr");
        customer3.setLastName("Zaba");

        Customer customer4 = new Customer();
        customer4.setFirstName("Krzysztof");
        customer4.setLastName("Zielinski");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);

        System.out.println("Data customer loaded = " + customerRepository.count() );
    }

    private void loadCategory() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data fruit loaded = " + categoryRepository.count() );
    }
}
