package repositories.impl;

import models.User;
import repositories.UsersRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * 7/14/2023
 * Architecture Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
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
