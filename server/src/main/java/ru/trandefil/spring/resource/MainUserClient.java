package ru.trandefil.spring.resource;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class MainUserClient {

    public static UserClient getInstance(){
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(UserClient.class))
                .logLevel(Logger.Level.FULL)
                .target(UserClient.class,"http://localhost:8080/rest/users");
    }

    public static void main(String[] args) {
        UserClient userClient = getInstance();
        userClient.findAll().forEach(System.out::println);
    }
}
