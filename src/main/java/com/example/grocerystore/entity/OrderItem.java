package com.example.grocerystore.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name ="order_item")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @Column(name = "order_item_id")
    private String orderItemId;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "product_id")
    private String productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
