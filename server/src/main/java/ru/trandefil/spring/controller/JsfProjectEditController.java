package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.LoggedUser;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.UserService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.security.Principal;
import java.util.logging.Logger;


@ManagedBean
@ApplicationScoped
public class JsfProjectEditController  extends SpringBeanAutowiringSupport implements Serializable {

    @Autowired
    private transient ProjectService projectService;

    @Autowired
    private transient UserService userService;

    private final transient Logger logger = Logger.getLogger(this.getClass().getName());

    private transient String id;

    private transient Project project = new Project();

    public void init() {
        logger.info("=============== jsfProjectEditController init with id = " + id);
        if (id == null) {
            final LoggedUser loggedUser = LoggedUser.getLoggedUser();
            if(loggedUser == null)
                throw new RuntimeException("Not logged user");
            final User logged = new User(loggedUser);
            logger.info("==================== logged user : " + logged);
            project.setUser(logged);
            return;
        }
        Project byId = projectService.getById(id);
        if (byId != null) {
            project = byId;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String save() {
        logger.info("======================= trying to save " + project);
        projectService.save(project);
        return "project-list.xhtml";
    }

}
