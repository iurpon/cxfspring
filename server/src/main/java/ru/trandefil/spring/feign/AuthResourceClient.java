package ru.trandefil.spring.feign;

import feign.Feign;
import feign.okhttp.OkHttpClient;
import okhttp3.JavaNetCookieJar;
import org.springframework.beans.factory.ObjectFactory;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.http.converter.FormHttpMessageConverter;
import ru.trandefil.spring.dto.Result;

import java.net.CookieManager;
import java.net.CookiePolicy;

public class AuthResourceClient {

    public static CookieManager cookieManager = new CookieManager();

    public static OkHttpClient client(){
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        final okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient().newBuilder();
        builder.cookieJar(new JavaNetCookieJar(cookieManager));
        OkHttpClient okHttpClient = new OkHttpClient(builder.build());
        return okHttpClient;
    }

    public static UserClient getUserInstance(final String url) {
        final FormHttpMessageConverter converter = new FormHttpMessageConverter();
        final HttpMessageConverters converters = new HttpMessageConverters(converter);
        final ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;
        return Feign.builder()
                .client(client())
                .contract(new SpringMvcContract())
                .encoder(new SpringEncoder(objectFactory))
                .decoder(new SpringDecoder(objectFactory))
                .target(UserClient.class, url);
    }

    public static UserAuth getInstance(final String url) {
        final FormHttpMessageConverter converter = new FormHttpMessageConverter();
        final HttpMessageConverters converters = new HttpMessageConverters(converter);
        final ObjectFactory<HttpMessageConverters> objectFactory = () -> converters;
        return Feign.builder()
                .client(client())
                .contract(new SpringMvcContract())
                .encoder(new SpringEncoder(objectFactory))
                .decoder(new SpringDecoder(objectFactory))
                .target(UserAuth.class, url);
    }

    public static void main(String[] args) {
        final UserAuth userAuth = getInstance("http://localhost:8080/rest");
        final Result login = userAuth.login("root", "root");
        System.out.println(login);
        userAuth.findAll().forEach(System.out::println);
        System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>");
        final UserClient userClient = getUserInstance("http://localhost:8080/rest");
        userClient.findAll().forEach(System.out::println);
//        System.out.println(userAuth.findById("a868deba-4fc0-4c56-a0d3-150619129314"));
    }

}
