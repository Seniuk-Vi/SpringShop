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
@Table(name="Users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String login;
    private String name;
    private String surname;
    @Column(unique = true)
    private String phone_number;
    @Column(unique = true)
    private String email;
    private String locale;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Role role;
    private boolean enabled;
    private String password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Order> orders;
}
