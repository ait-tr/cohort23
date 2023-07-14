package services;

import models.User;
import repositories.UsersRepository;

import java.util.List;

/**
 * 7/14/2023
 * Architecture Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void signUp(String email, String password) {

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Плохой email");
        }

        if (password.length() < 5) {
            throw new IllegalArgumentException("Плохой пароль!");
        }

        User user = new User(email, password);

        usersRepository.save(user);
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }
}
