package ru.trandefil.spring.feign;

import feign.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.trandefil.spring.model.User;

import java.util.List;

public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users/id")
    User findById(@Param("id") String id);

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    List<User> findAll();

}
