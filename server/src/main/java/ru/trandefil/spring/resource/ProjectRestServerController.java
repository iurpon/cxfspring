package ru.trandefil.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class ProjectRestServerController implements AbstractEntityRestController<Project> {

    @Autowired
    private ProjectService projectService;

    @Override
    @GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getAllEntities() {
        return projectService.getAll();
    }

    @Override
    @GetMapping(value = "/projects/{id}")
    public Project getEntity(@PathVariable("id") String id) {
        return projectService.getById(id);
    }

    @Override
    @PutMapping(
            value = "/projects/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Project updateEntity(@RequestBody Project entity,@PathVariable("id") String id) {
        return projectService.update(entity,id);
    }

    @Override
    @DeleteMapping(value = "/projects/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEntity(@PathVariable("id") String id) {
        projectService.deleteById(id);
    }

    @Override
    @PostMapping(
            value = "/projects",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Project createEntity(@RequestBody Project entity) {
        return projectService.save(entity);
    }

}
