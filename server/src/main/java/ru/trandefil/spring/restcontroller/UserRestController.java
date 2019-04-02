package ru.trandefil.spring.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserRestController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;

    @PostConstruct
    public void post(){
        logger.info("========================== post construct userService : " +  userService);
    }

    @GetMapping(value = "/server/rest")
    public String hello(){
        logger.info("=========================== user rest controller hello");
        return "hello";
    }


    @GetMapping(value = "/users",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(){
        logger.info("=========================== user rest controller get users");
        return userService.getAll();
    }

}
