package com.epam.springshop.model;

import javax.persistence.*;
import lombok.*;



@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long orderItemId;   // better to make orderId and ProductId primary and for keys
    @ManyToOne()
    Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    Product product;
    int quantity;
}

