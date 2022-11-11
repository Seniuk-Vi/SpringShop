package com.epam.springshop.model;

import javax.persistence.*;
import lombok.*;



@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String category;
}
