package ru.trandefil.spring.resource;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface UserClient {

    @RequestLine("GET /{id}")
    UserResource findById(@Param("id") String id);

    @RequestLine("GET")
    List<UserResource> findAll();

}
