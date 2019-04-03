package ru.trandefil.spring.service;

import ru.trandefil.spring.model.Session;
import ru.trandefil.spring.model.User;

import java.util.List;

public interface UserService {

    User getLoggedUser(String userName, String password);

    User save(User user);

    List<User> getAll();

    void deleteById(String id);

    User getById(String id);

    User getByName(String name);

    boolean deleteByName(String name);

    User constractUser(String name,String pass,String role);

    void logout(Session session);

    Session getSession(String userName,String userPassword);

    User update(User user, String id);

}
