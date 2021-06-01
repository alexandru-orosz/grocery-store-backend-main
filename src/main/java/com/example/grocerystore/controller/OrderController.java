package com.example.grocerystore.controller;

import com.example.grocerystore.dto.OrderDto;
import com.example.grocerystore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{email}")
    public ResponseEntity<List<OrderDto>> getOrdersByEmail(@PathVariable("email") String email){
        List<OrderDto> orders = orderService.findOrdersByEmail(email);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
