package com.example.grocerystore.service;

import com.example.grocerystore.dto.Purchase;
import com.example.grocerystore.dto.PurchaseResponse;
import com.example.grocerystore.entity.Customer;
import com.example.grocerystore.entity.Order;
import com.example.grocerystore.entity.OrderItem;
import com.example.grocerystore.factory.AddressFactory;
import com.example.grocerystore.factory.CustomerFactory;
import com.example.grocerystore.factory.OrderFactory;
import com.example.grocerystore.factory.OrderItemFactory;
import com.example.grocerystore.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class CheckoutService {

    private final CustomerRepository customerRepository;

    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = OrderFactory.generateOrder(purchase.getOrder());

        Set<OrderItem> orderItems = OrderItemFactory.generateOrderItems(purchase.getOrderItems());
        orderItems.forEach(order::add);

        order.setBillingAddress(AddressFactory.generateAddress(purchase.getBillingAddress()));
        order.setShippingAddress(AddressFactory.generateAddress(purchase.getShippingAddress()));

        Customer customer = CustomerFactory.generateCustomer(purchase.getCustomer());
        customer.add(order);

        customerRepository.save(customer);

        return new PurchaseResponse(order.getOrderTrackingNumber());
    }

}
