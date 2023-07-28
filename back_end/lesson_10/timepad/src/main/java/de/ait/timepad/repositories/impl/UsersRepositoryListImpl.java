package de.ait.timepad.repositories.impl;

import de.ait.timepad.models.User;
import de.ait.timepad.repositories.UsersRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Repository
public class UsersRepositoryListImpl implements UsersRepository {
    private static List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        if (user.getId() == null) {
            user.setId((long) users.size() + 1); // id пользователя - его порядковый номер в списке
            users.add(user);
        } else {
            // TODO: если бы это была база данных или файл, то нужно было бы обновить данные в хранилище
            // обновляем, но тут этого делать не нужно, потому что это список объектов
        }
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public Optional<User> findById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return Optional.of(user); // вместо return user
            }
        }

        return Optional.empty(); // вместо return null
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }

    @Override
    public void clear() {
        users.clear();
    }
}
