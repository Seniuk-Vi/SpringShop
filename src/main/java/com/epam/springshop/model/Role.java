package com.epam.springshop.model;

import javax.persistence.*;
import lombok.*;



@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String role;

}
