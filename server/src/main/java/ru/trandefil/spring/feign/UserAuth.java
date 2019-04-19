package ru.trandefil.spring.feign;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.model.User;

import java.util.List;

public interface UserAuth {

    @RequestMapping(method = RequestMethod.GET, value = "login?name={username}&password={password}")
    Result login(@PathVariable("username") String name, @PathVariable("password") String password);

/*    @RequestLine("GET /users/{id}")
    UserDTO findById(@Param("id") String id);*/

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    List<User> findAll();

}
