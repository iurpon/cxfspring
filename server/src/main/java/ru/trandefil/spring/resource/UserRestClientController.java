package ru.trandefil.spring.resource;

import ru.trandefil.spring.model.User;

import java.util.List;

public class UserRestClientController implements UserRestController {
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(String id) {
        return null;
    }

    @Override
    public void update(User user, String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User create(User user) {
        return null;
    }
}
