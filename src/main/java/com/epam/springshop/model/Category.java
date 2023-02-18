package com.epam.springshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
@Entity
@Table(name = "categories", uniqueConstraints = {
        @UniqueConstraint(name = "category_uq", columnNames = "category")
})
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String category;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> product;
}
