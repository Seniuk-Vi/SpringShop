package com.epam.springshop.model;

import com.epam.springshop.model.enums.StatusEnum;

import javax.persistence.*;

import lombok.*;


import javax.swing.undo.StateEdit;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "Orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) default 'PAYED'")
    @NotNull
    private StatusEnum status;
    @NotNull
    private  Date orderDate;
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_id_fk"))
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private  Set<OrderItem> orderItems;
}
