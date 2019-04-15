package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;


@ViewScoped
@ManagedBean
public class JsfUserListController implements Serializable {

    @Autowired
    private transient UserService userService;

    @Autowired
    private transient HttpSession session;

    @PostConstruct
    private void init() {
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }

    public List<User> getUsers() {
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()){
            System.out.println(attributeNames.nextElement());
        }
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

    public void logout() throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance()
                .getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/logout");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());
    }

}
