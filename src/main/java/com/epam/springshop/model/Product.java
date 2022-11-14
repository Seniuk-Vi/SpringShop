package com.epam.springshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;


import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString

@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @NotNull
    private String title;
    @NotNull
    private  String description;
    @NotNull
    private Double price;
    @NotNull
    private String image_url;
    @NotNull
    private  Date post_date;
    @NotNull
    private Integer in_stock;
    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", foreignKey = @ForeignKey(name = "category_id_fk"))
    private Category category;

}
