package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.service.ProjectService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@ViewScoped
@ManagedBean
public class JsfProjectListController extends SpringBeanAutowiringSupport implements Serializable {

    private static final long serialVersionUID = 10L;

    @Inject
    private transient ProjectService projectService;

    private transient Logger logger = Logger.getLogger(this.getClass().getName());

    public List<Project> getProjects() {
        System.out.println(" jsf task list controller getUsers");
        if (projectService == null) {
            System.out.println("not injected user service");
        }
        List<Project> all = projectService.getAll();
        all.forEach(System.out::println);
        return all;
    }

    public void removeById(String id) {
        projectService.deleteById(id);
    }

}
