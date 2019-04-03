package ru.trandefil.spring.resource;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.trandefil.spring.model.User;

import java.util.List;

public class UserRestClientController implements UserRestController {

    private final String REQ_URL = "http://localhost:8080/server/rest/users/";

    @Override
    public List<User> getUsers() {
        final RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> response = restTemplate.exchange(
                REQ_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                });
        final List<User> users = response.getBody();
        return users;
    }

    @Override
    public User getUser(String id) {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(REQ_URL + id, User.class);
        final User user = userResponseEntity.getBody();
        return user;
    }

    @Override
    public void update(User user, String id) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<User> requestUpdate = new HttpEntity<>(user, headers);
        final RestTemplate template = new RestTemplate();
        template.exchange(REQ_URL + id, HttpMethod.PUT, requestUpdate, Void.class);

    }

    @Override
    public void delete(String id) {
        final RestTemplate template = new RestTemplate();
        template.delete(REQ_URL + id);
    }

    @Override
    public User create(User user) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<User> request = new HttpEntity<>(user);
        final User created = restTemplate.postForObject(REQ_URL, request, User.class);
        return created;
    }
}
