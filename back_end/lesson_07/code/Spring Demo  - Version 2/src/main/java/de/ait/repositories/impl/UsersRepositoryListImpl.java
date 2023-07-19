package de.ait.repositories.impl;

import de.ait.repositories.UsersRepository;
import de.ait.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 7/14/2023
 * Architecture Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Component(value = "usersRepositoryList")
public class UsersRepositoryListImpl implements UsersRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
