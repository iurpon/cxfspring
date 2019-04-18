package ru.trandefil.spring.feign;

/*import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.converter.FormHttpMessageConverter;
import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.dto.UserDTO;*/

public class MainUserClient {

/*    public static UserAuth getInstance1() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(UserClient.class))
                .logLevel(Logger.Level.FULL)
                .target(UserAuth.class, "http://localhost:8080/rest");
    }

    public static UserAuth getInstance2() {

        final FormHttpMessageConverter converter = new FormHttpMessageConverter();
        final HttpMessageConverters converters = new HttpMessageConverters(converter);
        final ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;

        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(UserAuth.class))
                .logLevel(Logger.Level.FULL)
                .target(UserAuth.class, "http://localhost:8080/rest");
    }

    public static void main(String[] args) {
        UserAuth userAuth = getInstance2();
        Result login = userAuth.login("root", "root");
        System.out.println(login);
        UserDTO byId = userAuth.findById("a868deba-4fc0-4c56-a0d3-150619129314");
        System.out.println();
    }*/

}
