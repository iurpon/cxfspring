package ru.trandefil.spring.resource;

import java.util.List;

public interface AbstractEntityRestController<T> {

    List<T> getAllEntities();

    T getEntity(String id);

    T updateEntity(T entity, String id);

    void deleteEntity(String id);

    T createEntity(T entity);

}
