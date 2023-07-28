package de.ait.timepad.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(T entity);

    List<T> findAll();

    Optional<T> findById(Long id);

    void delete(T entity);
}
