package ru.trandefil.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.trandefil.spring.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, String> {


    @Query("select p from Project p")
    List<Project> getAll();

    @Override
    <S extends Project> S save(S s);

    @Override
    Optional<Project> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    void deleteById(String s);

    @Override
    void delete(Project project);

    Project getByName(@Param("name") String name);

}
