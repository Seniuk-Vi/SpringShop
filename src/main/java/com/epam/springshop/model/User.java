package com.epam.springshop.model;

import com.epam.springshop.model.enums.RoleEnum;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "Users", uniqueConstraints = {
        @UniqueConstraint(name = "login_uq", columnNames = "login"),
        @UniqueConstraint(name = "phone_number_uq", columnNames = "phone_number"),
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
    @Column(name = "phone_number")
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
    @ToString.Exclude
    private List<Order> orders;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && Objects.equals(name, user.name)
                && Objects.equals(surname, user.surname)
                && Objects.equals(email, user.email)
                && Objects.equals(locale, user.locale)
                && Objects.equals(phoneNumber, user.phoneNumber)
                && Objects.equals(role, user.role)
                && Objects.equals(enabled, user.enabled);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email,
                password, login, locale, phoneNumber, role, enabled);
    }
}
