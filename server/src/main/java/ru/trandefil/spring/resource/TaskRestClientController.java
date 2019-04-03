package ru.trandefil.spring.resource;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.trandefil.spring.model.Task;

import java.util.List;

public class TaskRestClientController implements AbstractEntityRestController<Task> {

    private final String TASKS_URL = "http://localhost:8080/server/rest/tasks/";

    @Override
    public List<Task> getAllEntities() {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<List<Task>> response = restTemplate.exchange(
                TASKS_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {
                }
        );
        return response.getBody();
    }

    @Override
    public Task getEntity(String id) {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<Task> projectResponseEntity = restTemplate.getForEntity(TASKS_URL + id, Task.class);
        return projectResponseEntity.getBody();
    }

    @Override
    public Task updateEntity(Task entity, String id) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Task> requestUpdate = new HttpEntity<>(entity, headers);
        final RestTemplate template = new RestTemplate();
        return template.exchange(TASKS_URL + id, HttpMethod.PUT, requestUpdate, Task.class).getBody();
    }

    @Override
    public void deleteEntity(String id) {
        final RestTemplate template = new RestTemplate();
        template.delete(TASKS_URL + id);
    }

    @Override
    public Task createEntity(Task entity) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<Task> request = new HttpEntity<>(entity);
        return restTemplate.postForObject(TASKS_URL, request, Task.class);
    }

}
