package ru.trandefil.spring.resource;

import lombok.NonNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.trandefil.spring.model.User;

import java.util.List;

public class UserRestClientController implements UserRestController {

    private final String USERS_URL = "http://localhost:8080/server/rest/users/";

    @Override
    public List<User> getUsers() {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<List<User>> response = restTemplate.exchange(
                USERS_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                });
        return response.getBody();
    }

    @Override
    public User getUser(@NonNull final String id) {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(USERS_URL + id, User.class);
        final User user = userResponseEntity.getBody();
        return user;
    }

    @Override
    public void update(User user, String id) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<User> requestUpdate = new HttpEntity<>(user, headers);
        final RestTemplate template = new RestTemplate();
        template.exchange(USERS_URL + id, HttpMethod.PUT, requestUpdate, Void.class);
    }

    @Override
    public void delete(String id) {
        final RestTemplate template = new RestTemplate();
        template.delete(USERS_URL + id);
    }

    @Override
    public User create(User user) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<User> request = new HttpEntity<>(user);
        final User created = restTemplate.postForObject(USERS_URL, request, User.class);
        return created;
    }

}
