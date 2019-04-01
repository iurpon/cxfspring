package ru.trandefil.spring.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.Task;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.ProjectService;
import ru.trandefil.spring.service.TaskService;
import ru.trandefil.spring.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.logging.Logger;

@ViewScoped
@ManagedBean
public class JsfTaskEditController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private String id;

    private Task task = new Task();

    public void init() {
        logger.info("=============== jsfProjectEditController init");
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
        if (id == null) {
            final User assignee = userService.getByName("root");
            task.setAssignee(assignee);
            return;
        }
        Task byId = taskService.getById(id);
        if (byId != null) {
            task = byId;
        }
    }

    public Iterable<Project> getProjects() {
        return projectService.getAll();
    }

    public Iterable<User> getUsers(){
        return userService.getAll();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void setProjectId(String projectId) {
        logger.info("=================== setProject ID");
        final Project project = projectService.getById(projectId);
        task.setProject(project);
    }

    public String getProjectId() {
        logger.info("================ get Project ID");
        if (task.getProject() == null) return null;
        return task.getProject().getId();
    }

    public Date getStart() {
        logger.info("================ get start ");
        if (task.getStart() == null) return null;
        return task.getStart();
    }

    public void setStart(Date start) {
        logger.info("================ set start ");
        task.setStart(start);
    }

    public Date getEnd() {
        logger.info("================ get end ");
        if (task.getEnd() == null) return null;
        return task.getEnd();
    }

    public void setEnd(Date end) {
        logger.info("================ set end ");
        task.setEnd(end);
    }

    public String getExecutorId() {
        logger.info("===================== get executor id");
        if (task.getExecutor() == null) return null;
        return task.getExecutor().getId();
    }

    public void setExecutorId(@NonNull final String executorId) {
        logger.info("=================== set executor id");
        final User executor = userService.getById(executorId);
        task.setExecutor(executor);
    }

    public String save() {
        logger.info("========================= task save() : " + task );
        taskService.save(task);
        return "task-list.xhtml";
    }

}
