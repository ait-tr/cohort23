package de.ait.config;

import de.ait.repositories.UsersRepository;
import de.ait.repositories.impl.UsersRepositoryFileImpl;
import de.ait.repositories.impl.UsersRepositoryListImpl;
import de.ait.validators.EmailValidator;
import de.ait.validators.PasswordValidator;
import de.ait.validators.impl.EmailValidatorRegexImpl;
import de.ait.validators.impl.EmailValidatorSimpleImpl;
import de.ait.validators.impl.PasswordLengthValidatorImpl;
import de.ait.validators.impl.PasswordValidatorCheckCharactersImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

/**
 * 7/19/2023
 * Spring Demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = "de.ait")
public class ApplicationConfig {

    @Bean
    public PasswordValidator passwordValidatorCheckCharacters() {
        PasswordValidatorCheckCharactersImpl validator = new PasswordValidatorCheckCharactersImpl();
        validator.setCharacters(Arrays.asList('%', '!', '+', '?'));
        return validator;
    }
}
