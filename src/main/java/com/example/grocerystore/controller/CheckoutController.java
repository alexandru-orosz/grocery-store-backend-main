package com.example.grocerystore.controller;

import com.example.grocerystore.dto.Purchase;
import com.example.grocerystore.dto.PurchaseResponse;
import com.example.grocerystore.service.CheckoutService;
import com.example.grocerystore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/checkout")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final ProductService productService;
    private final Logger logger = Logger.getLogger(CheckoutController.class.getName());
    private final RestTemplate restTemplate = new RestTemplate();
    private final boolean SEND_EMAIL = true;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        logger.log(Level.INFO, "A new order has been placed. Tracking number: " + purchaseResponse.getOrderTrackingNumber());

        if(SEND_EMAIL) {
            purchase.getOrder().setOrderTrackingNumber(purchaseResponse.getOrderTrackingNumber());
            purchase.getOrderItems().forEach(orderItemDto ->
                    orderItemDto.setProductName(productService.findProductById(orderItemDto.getProductId()).getName()));
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<Purchase> entity = new HttpEntity<>(purchase, headers);
            restTemplate.exchange("http://localhost:7777/email/send", HttpMethod.POST, entity, String.class);
        }

        return new ResponseEntity<>(purchaseResponse, HttpStatus.OK);
    }
}
