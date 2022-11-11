package com.epam.springshop.model;

import com.epam.springshop.model.enums.StatusEnum;
import javax.persistence.*;
import lombok.*;


import javax.swing.undo.StateEdit;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    User user;
    StatusEnum status;
    Date orderDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<OrderItem> orderItems;
}
