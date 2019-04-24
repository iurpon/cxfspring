package ru.trandefil.spring.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;


@ViewScoped
@ManagedBean
public class JsfUserListController extends SpringBeanAutowiringSupport implements Serializable {

    private static final long serialVersionUID = 10L;

    @Inject
    private transient UserService userService;

    public List<User> getUsers() {
        System.out.println(" jsf task list controller getUsers");
        if (userService == null) {
            System.out.println("not injected user service");
        }
        List<User> all = userService.getAll();
        all.forEach(System.out::println);
        return all;
    }

    public void removeById(String id) {
        userService.deleteById(id);
    }

    public void logout() throws ServletException, IOException {
        System.out.println("=========================== logout ");
        SecurityContextHolder.getContext().setAuthentication(null);
    }

}
