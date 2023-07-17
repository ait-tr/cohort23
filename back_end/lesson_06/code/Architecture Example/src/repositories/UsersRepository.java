package repositories;

import models.User;

import java.util.List;

/**
 * 7/14/2023
 * Architecture Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersRepository {
    void save(User user);

    List<User> findAll();
}
