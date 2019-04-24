package ru.trandefil.spring.service;

import ru.trandefil.spring.model.Project;
import ru.trandefil.spring.model.Session;
import ru.trandefil.spring.model.User;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getById(String id);

    void delete(Project project);

    List<Project> getAll();

    void deleteById(String id);

    Project getByName(String name);

    Project saveNew(String name, String description, User user);

    Project update(Project fromDTO);

    void deleteByName(String projectName);

    Project update(Project project, String id);

}
