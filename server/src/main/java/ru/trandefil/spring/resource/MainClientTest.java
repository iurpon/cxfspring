package ru.trandefil.spring.resource;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.trandefil.spring.dto.Result;
import ru.trandefil.spring.model.User;

import java.util.List;


public class MainClientTest {


    public static void main(String[] args) {

        final String url = "http://localhost:8080/rest/login?name=root&password=root";
        final String USERS_URL = "http://localhost:8080/rest/users/";

        RestTemplate template = new RestTemplate();

        HttpEntity<Result> response = template.exchange(url, HttpMethod.GET, null, Result.class);
        HttpHeaders headers = response.getHeaders();
        String set_cookie = headers.getFirst(headers.SET_COOKIE);

        System.out.println("Response: " + response.toString() + "\n");
        System.out.println("Set-Cookie: " + set_cookie + "\n");
        System.out.println("********* FINISH *******");


//        RestTemplate restTemplate = new RestTemplate();
/*        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Cookie", "credentials=" + set_cookie);*/
//        HttpEntity requestEntity = new HttpEntity(null, headers);
//        ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Users.class);
        System.out.println("================================== any request ? ");
        final ResponseEntity<List<User>> responseList = template.exchange(
                USERS_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                });
        System.out.println("=============================  any responceList? " + responseList);
        responseList.getBody().forEach(System.out::println);

    }
}
