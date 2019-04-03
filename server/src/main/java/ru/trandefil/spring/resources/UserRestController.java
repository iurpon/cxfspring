package ru.trandefil.spring.resources;

import ru.trandefil.spring.model.User;

import java.util.List;

public interface UserRestController {

    List<User> getUsers();

    User getUser(String id);

    void update(User user,String id);

    void delete(String id);

    User create(User user);

}
