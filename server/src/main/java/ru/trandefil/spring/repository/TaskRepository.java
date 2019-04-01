package ru.trandefil.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trandefil.spring.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,String> {

    @Override
    List<Task> findAll();

    @Override
    <S extends Task> S save(S s);

    @Override
    Optional<Task> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    void deleteById(String s);

    @Override
    void delete(Task task);



}
