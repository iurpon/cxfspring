package ru.trandefil.spring.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.trandefil.spring.model.User;
import ru.trandefil.spring.service.UserService;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserRestController {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private UserService userService;


    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        logger.info("=========================== user rest controller get users");
        return userService.getAll();
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable("id") String id) {
        logger.info("=========================== user rest controller get user{id}");
        final User user = userService.getById(id);
        return user;
    }

    @PutMapping(value = "/users/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user, @PathVariable("id") String id){
        logger.info("=========================== user rest controller update user{id}");
        userService.update(user,id);
    }

    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id){
        logger.info("============================= user rest controller delete user{id}");
        userService.deleteById(id);
    }

}
