package de.ait.validators.impl;

import de.ait.validators.EmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 7/19/2023
 * Spring Demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class EmailValidatorRegexImpl implements EmailValidator {
    private final Pattern pattern;

    public EmailValidatorRegexImpl(String regex) {
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
