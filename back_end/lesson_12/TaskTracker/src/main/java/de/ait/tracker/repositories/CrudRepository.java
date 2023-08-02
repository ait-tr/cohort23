package de.ait.tracker.repositories;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
}
