package ru.trandefil.spring.service;

import ru.trandefil.spring.model.Project;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getById(String id);

    void delete(Project project);

    List<Project> getAll();

    void deleteById(String id);

}
