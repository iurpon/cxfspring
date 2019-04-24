package ru.trandefil.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.jsf.FacesContextUtils;
import ru.trandefil.spring.model.Task;
import ru.trandefil.spring.service.TaskService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@ViewScoped
@ManagedBean
public class JsfTaskListController extends SpringBeanAutowiringSupport implements Serializable {

    @Autowired
    private transient TaskService taskService;

    private final transient Logger logger = Logger.getLogger(this.getClass().getName());

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
