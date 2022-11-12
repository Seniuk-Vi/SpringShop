package com.epam.springshop.model;

import javax.persistence.*;
import lombok.*;



@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderItemId;
    @ManyToOne()
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "order_id_fk"))
    private  Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", foreignKey = @ForeignKey(name = "product_id_fk"))
    private Product product;
    private int quantity;
}

