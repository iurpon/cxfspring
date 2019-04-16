package ru.trandefil.spring.resource;

import lombok.NonNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.trandefil.spring.model.Project;

import java.util.List;

@Component
public class ProjectRestClientController implements AbstractEntityRestController<Project> {

    private final String PROJECTS_URL = "http://localhost:8080/rest/projects/";

    @Override
    public List<Project> getAllEntities() {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<List<Project>> response = restTemplate.exchange(
                PROJECTS_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Project>>() {
                }
        );
        return response.getBody();
    }

    @Override
    public Project getEntity(@NonNull final String id) {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<Project> projectResponseEntity = restTemplate.getForEntity(PROJECTS_URL + id, Project.class);
        return projectResponseEntity.getBody();
    }

    @Override
    public Project updateEntity(@NonNull final Project entity, @NonNull final String id) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<Project> requestUpdate = new HttpEntity<>(entity, headers);
        final RestTemplate template = new RestTemplate();
        return template.exchange(PROJECTS_URL + id, HttpMethod.PUT, requestUpdate, Project.class).getBody();
    }

    @Override
    public void deleteEntity(@NonNull final String id) {
        final RestTemplate template = new RestTemplate();
        template.delete(PROJECTS_URL + id);
    }

    @Override
    public Project createEntity(@NonNull final Project entity) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<Project> request = new HttpEntity<>(entity);
        return restTemplate.postForObject(PROJECTS_URL, request, Project.class);
    }

}
