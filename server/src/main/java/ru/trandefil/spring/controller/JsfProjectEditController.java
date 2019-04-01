package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.logging.Logger;

@ViewScoped
@ManagedBean
public class JsfProjectEditController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private String id;

    private Project project = new Project();

    public void init() {
        logger.info("=============== jsfProjectEditController init");
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
        if (id == null) {
            final User logged = userService.getByName("root");
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
