package ru.trandefil.spring.resource;

import lombok.NonNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.trandefil.spring.model.User;

import java.util.List;

@Component
public class UserRestClientController implements AbstractEntityRestController<User> {

    private final String USERS_URL = "http://localhost:8080/rest/users/";

    @Override
    public List<User> getAllEntities() {
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
    public User getEntity(@NonNull final String id) {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(USERS_URL + id, User.class);
        return userResponseEntity.getBody();
    }

    @Override
    public User updateEntity(@NonNull final User entity, @NonNull final String id) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<User> requestUpdate = new HttpEntity<>(entity, headers);
        final RestTemplate template = new RestTemplate();
        return template.exchange(USERS_URL + id, HttpMethod.PUT, requestUpdate, User.class).getBody();
    }

    @Override
    public void deleteEntity(@NonNull final String id) {
        final RestTemplate template = new RestTemplate();
        template.delete(USERS_URL + id);
    }

    @Override
    public User createEntity(@NonNull final User entity) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<User> request = new HttpEntity<>(entity);
        return restTemplate.postForObject(USERS_URL, request, User.class);
    }

}
