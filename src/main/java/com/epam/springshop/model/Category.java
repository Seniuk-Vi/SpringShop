package com.epam.springshop.model;

import javax.persistence.*;

import lombok.*;

import java.util.List;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "categories", uniqueConstraints = {
        @UniqueConstraint(name = "category_uq", columnNames = "category")
})
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String category;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> product;
}
