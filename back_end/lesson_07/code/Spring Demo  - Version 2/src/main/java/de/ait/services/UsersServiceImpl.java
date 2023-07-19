package de.ait.services;


import de.ait.repositories.UsersRepository;
import de.ait.models.User;
import de.ait.validators.EmailValidator;
import de.ait.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 7/14/2023
 * Architecture Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Component
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    private final EmailValidator emailValidator;

    private final PasswordValidator passwordValidator;

    @Autowired
    public UsersServiceImpl(@Qualifier("usersRepositoryFile") UsersRepository usersRepository,
                             @Qualifier("emailValidatorRegex") EmailValidator emailValidator,
                             @Qualifier("passwordValidatorCheckCharacters") PasswordValidator passwordValidator) {
        this.usersRepository = usersRepository;
        this.emailValidator = emailValidator;
        this.passwordValidator = passwordValidator;
    }

    @Override
    public void signUp(String email, String password) {

        emailValidator.validate(email);

        passwordValidator.validate(password);

        User user = new User(email, password);

        usersRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }
}
