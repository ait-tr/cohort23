package de.ait.validators.impl;

import de.ait.validators.EmailValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 7/19/2023
 * Spring Demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Component("emailValidatorRegex")
public class EmailValidatorRegexImpl implements EmailValidator {
    private final Pattern pattern;

    public EmailValidatorRegexImpl(@Value("${email.regex}") String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public void validate(String email) {
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Email не соответствует нужному формату");
        }
    }
}
