package ru.trandefil.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trandefil.spring.enums.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity {

    @Column(unique = true)
    private String name;

    @Column
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Project> projects = new ArrayList<>();

    public User(String id, String name, String password, Role role) {
        super(id);
        this.name = name;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", id='" + id + '\'' +
                '}';
    }
}
