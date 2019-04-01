package ru.trandefil.spring.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.trandefil.spring.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,String> {

    @Override
    List<Task> findAll();

    @Override
    <S extends Task> S save(@NonNull final S s);

    @Override
    Optional<Task> findById(@NonNull final String s);

    @Override
    boolean existsById(@NonNull final String s);

    @Override
    void deleteById(@NonNull final String s);

    @Override
    void delete(@NonNull final Task task);

/*    @Query("delete from Task t where t.name = :name")
    void deleteByName(@NonNull final String name);*/

    void deleteByName(@Param("name") String name);

    @Query("select t from Task t where t.name = :name")
    Task getByName(@NonNull final String name);

}
