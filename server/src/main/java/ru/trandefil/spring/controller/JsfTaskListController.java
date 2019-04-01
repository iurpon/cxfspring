package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.Task;
import ru.trandefil.spring.service.TaskService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.logging.Logger;

@ViewScoped
@ManagedBean
public class JsfTaskListController {

    @Autowired
    private TaskService taskService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @PostConstruct
    public void init(){
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
    }

    public List<Task> getTasks(){
        logger.info("============================== jsfTaskListController getTasks");
        if(taskService == null){
            logger.info("============================ taskService is null");
        }
        return taskService.getAll();
    }

    public String deleteById(String id){
        logger.info("======================================== task delete by id");
        taskService.deletById(id);
        return "task-list";
    }

}
