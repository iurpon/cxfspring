package ru.trandefil.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.trandefil.spring.enums.Role;
import ru.trandefil.spring.model.LoggedUser;
import ru.trandefil.spring.model.User;

import javax.xml.bind.annotation.XmlTransient;

public class UserDTO {

    private String id;

    private String name;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private Role role;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.role = user.getRole();
    }

    public UserDTO(LoggedUser loggedUser){
        this.name = loggedUser.getUsername();
    }

    public UserDTO(String id, String name, String password, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", role=" + role +
                '}';
    }

}
