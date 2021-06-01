package com.example.grocerystore.repository;

import com.example.grocerystore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {

    List<Order> findAllByCustomerEmailOrderByDateCreatedDesc(String email);
}
