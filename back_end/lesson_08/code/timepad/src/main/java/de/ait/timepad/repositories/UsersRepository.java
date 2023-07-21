package de.ait.timepad.repositories;

import de.ait.timepad.models.User;

import java.util.List;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersRepository {
    void save(User user);

    List<User> findAll();

    void clear();
}
