package ru.trandefil.spring.restcontroller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.trandefil.spring.enums.Role;
import ru.trandefil.spring.model.User;

import java.util.List;
import java.util.logging.Logger;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class UserRestControllerTest {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    private final User TEST = new User("bf6ff99e-e53a-4562-a934-1e364684ced0", "test", "test", Role.USER);


    @Before
    public void before() {
        final String url = "http://localhost:8080/server/rest/users/" + TEST.getId();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> requestUpdate = new HttpEntity<>(TEST, headers);
        RestTemplate template = new RestTemplate();
        template.exchange(url, HttpMethod.PUT, requestUpdate, Void.class);
    }

    @Test
    public void getUsers() {
        final RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8080/server/rest/users/";
        ResponseEntity<List<User>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                });
        List<User> users = response.getBody();
        users.forEach(System.out::println);
    }

    @Test
    public void getUser() {
        final RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8080/server/rest/users/" + TEST.getId();
        final ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(url, User.class);
        final User user = userResponseEntity.getBody();
        logger.info(user.toString());
        assertEquals(user.getName(), "test");
        assertThat(userResponseEntity.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void update() {
        TEST.setName("newTest");
        final String url = "http://localhost:8080/server/rest/users/" + TEST.getId();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> requestUpdate = new HttpEntity<>(TEST, headers);
        RestTemplate template = new RestTemplate();
        template.exchange(url, HttpMethod.PUT, requestUpdate, Void.class);
    }

    @Test
    public void delete() {
        final String url = "http://localhost:8080/server/rest/users/" + TEST.getId();
        final RestTemplate template = new RestTemplate();
        template.delete(url);
    }

}