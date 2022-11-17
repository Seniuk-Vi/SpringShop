package com.epam.springshop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.epam.springshop.model.enums.RoleEnum;
import lombok.*;


import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(name = "login_uq", columnNames = "login"),
        @UniqueConstraint(name = "phone_number_uq", columnNames = "phoneNumber"),
        @UniqueConstraint(name = "email_uq", columnNames = "email")})
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String login;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String email;
    @Column(nullable = false)
    @NotNull
    private String locale;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) default 'USER'")
    private RoleEnum role;
    @NotNull
    private boolean enabled;
    @NotNull
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",fetch = FetchType.LAZY)
    private List<Order> orders;
}
