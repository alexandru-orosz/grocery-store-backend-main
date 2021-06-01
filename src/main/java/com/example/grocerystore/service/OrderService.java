package com.example.grocerystore.service;

import com.example.grocerystore.dto.OrderDto;
import com.example.grocerystore.mapper.OrderMapper;
import com.example.grocerystore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDto> findOrdersByEmail(String email) {
        return orderRepository.findAllByCustomerEmailOrderByDateCreatedDesc(email).stream().map(OrderMapper::entityToDto).collect(Collectors.toList());
    }

}
