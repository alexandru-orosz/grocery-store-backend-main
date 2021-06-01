package com.example.grocerystore.repository;

import com.example.grocerystore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByEmail(String email);

}
