package com.epam.springshop.model;

import com.epam.springshop.model.enums.StatusEnum;
import lombok.Builder;
import lombok.Data;

import javax.swing.undo.StateEdit;
import java.sql.Date;
import java.util.List;

@Builder
@Data
public class Order {
    long id;
    User user;
    StatusEnum status;
    Date orderDate;
   // List<OrderItem> orderItems;
}
