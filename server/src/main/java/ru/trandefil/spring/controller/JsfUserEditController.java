package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.logging.Logger;


@ViewScoped
@ManagedBean
public class JsfUserEditController {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private String id;

    private User user = new User();

    public void init() {
        logger.info("=============== jsfUserEditController init");

        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
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
        userService.save(user);
        return "user-list.xhtml";
    }

}
