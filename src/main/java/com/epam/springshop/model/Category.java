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
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", unique = true, foreignKey = @ForeignKey(name = "product_id_fk"))
    private List<Product> product;
}
