package ru.trandefil.spring.resource;

import ru.trandefil.spring.model.User;

public class UserResource {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserResource() {
    }

}
