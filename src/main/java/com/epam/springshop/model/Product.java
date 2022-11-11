package com.epam.springshop.model;

import javax.persistence.*;
import lombok.*;


import java.util.Date;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String description;
    Double price;
    String image_url;
    Date post_date;
    Integer in_stock;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    Category category;

}
