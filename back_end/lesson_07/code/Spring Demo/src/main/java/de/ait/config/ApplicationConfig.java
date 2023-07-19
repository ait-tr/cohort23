package de.ait.config;

import de.ait.repositories.UsersRepository;
import de.ait.repositories.impl.UsersRepositoryFileImpl;
import de.ait.repositories.impl.UsersRepositoryListImpl;
import de.ait.services.UsersServiceImpl;
import de.ait.services.UsersService;
import de.ait.validators.EmailValidator;
import de.ait.validators.PasswordValidator;
import de.ait.validators.impl.EmailValidatorRegexImpl;
import de.ait.validators.impl.EmailValidatorSimpleImpl;
import de.ait.validators.impl.PasswordLengthValidatorImpl;
import de.ait.validators.impl.PasswordValidatorCheckCharactersImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * 7/19/2023
 * Spring Demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class ApplicationConfig {

    @Bean
    public UsersRepository usersRepositoryFile() {
        return new UsersRepositoryFileImpl();
    }

    @Bean
    public UsersRepository usersRepositoryList() {
        return new UsersRepositoryListImpl();
    }

    @Bean
    public PasswordValidator passwordValidatorCheckCharacters() {
        PasswordValidatorCheckCharactersImpl validator = new PasswordValidatorCheckCharactersImpl();
        validator.setCharacters(Arrays.asList('%', '!', '+', '?'));
        return validator;
    }

    @Bean
    public PasswordValidator passwordValidatorLength() {
        return new PasswordLengthValidatorImpl(5);
    }

    @Bean
    public EmailValidator emailValidatorSimple() {
        return new EmailValidatorSimpleImpl();
    }

    @Bean
    public EmailValidator emailValidatorRegex() {
        return new EmailValidatorRegexImpl("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    @Bean
    public UsersService usersService(
            @Qualifier("usersRepositoryFile") UsersRepository usersRepository,
            @Qualifier("emailValidatorRegex") EmailValidator emailValidator,
            @Qualifier("passwordValidatorCheckCharacters") PasswordValidator passwordValidator) {
        return new UsersServiceImpl(usersRepository, emailValidator, passwordValidator);
    }
}
