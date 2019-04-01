package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;


@ViewScoped
@ManagedBean
public class JsfUserListController {

    @Autowired
    private UserService userService;

    @PostConstruct
    private void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }

    public List<User> getUsers() {
        System.out.println(" jsf task list controller getUsers");
        if (userService == null) {
            System.out.println("not injected user service");

        }
        List<User> all = userService.getAll();
        all.forEach(System.out::println);
        return all;
    }

    public void removeById(String id){
        userService.deleteById(id);
    }

}
