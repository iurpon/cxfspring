package ru.trandefil.spring.feign;

import feign.Param;
import feign.RequestLine;
import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.model.User;

import java.util.List;

public interface UserAuth {

    @RequestLine("GET /login?name={username}&password={password}")
    Result login(@Param("username") String name, @Param("password") String password);

    @RequestLine("GET /users/{id}")
    UserResource findById(@Param("id") String id);

    @RequestLine("GET /users")
    List<User> findAll();

}
