package ru.trandefil.spring.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.trandefil.spring.model.Task;
import ru.trandefil.spring.service.TaskService;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class TaskRestServerController implements AbstractEntityRestController<Task> {

    @Autowired
    private TaskService taskService;

    @Override
    @GetMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getAllEntities() {
        return taskService.getAll();
    }

    @Override
    @GetMapping(value = "/tasks/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task getEntity(@RequestParam("id") String id) {
        return taskService.getById(id);
    }

    @Override
    @PutMapping(
            value = "/tasks/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Task updateEntity(@RequestBody Task entity, @RequestParam("id") String id) {
        return taskService.update(entity, id);
    }

    @Override
    @DeleteMapping(value = "/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntity(@RequestParam("id") String id) {
        taskService.deletById(id);
    }

    @Override
    @PostMapping(
            value = "/tasks",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Task createEntity(@RequestBody Task entity) {
        return taskService.save(entity);
    }

}
