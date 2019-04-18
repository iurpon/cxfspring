package ru.trandefil.spring.feign;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import ru.trandefil.spring.dto.Result;

public class MainUserClient {

    public static UserClient getInstance1(){
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(UserClient.class))
                .logLevel(Logger.Level.FULL)
                .target(UserClient.class,"http://localhost:8080/rest/users");
    }

    public static UserAuth getInstance2(){
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(UserAuth.class))
                .logLevel(Logger.Level.FULL)
                .target(UserAuth.class,"http://localhost:8080/rest");
    }

    public static void main(String[] args) {
        UserAuth userAuth = getInstance2();
        Result login = userAuth.login("root", "root");
        System.out.println(login);
        System.out.println(userAuth.findById("a868deba-4fc0-4c56-a0d3-150619129314").getUser());
    }

}
