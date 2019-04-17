package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.logging.Logger;



@ManagedBean
@ApplicationScoped
public class JsfUserEditController extends SpringBeanAutowiringSupport implements Serializable{

    @Autowired
    private transient UserService userService;

    private transient Logger logger = Logger.getLogger(this.getClass().getName());

    private transient String id;

    private transient User user = new User();

    public void init() {
        logger.info("=============== jsfUserEditController init");

        if (id == null) {
            return;
        }
        User byId = userService.getById(id);
        if (byId != null) {
            user = byId;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String save() {
        logger.info("===================== jsfuseredit save");
        System.out.println(userService);
        System.out.println(user);
        userService.save(user);
        return "user-list.xhtml";
    }

}
