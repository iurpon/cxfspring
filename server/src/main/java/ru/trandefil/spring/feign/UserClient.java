package ru.trandefil.spring.feign;

import feign.Param;
import feign.RequestLine;
import ru.trandefil.spring.model.User;

import java.util.List;

public interface UserClient {

    @RequestLine("GET /{id}")
    User findById(@Param("id") String id);

    @RequestLine("GET")
    List<User> findAll();

}
