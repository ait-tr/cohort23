package de.ait.validators.impl;

import de.ait.validators.PasswordValidator;

/**
 * 7/19/2023
 * Spring Demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class PasswordLengthValidatorImpl implements PasswordValidator {

    private final int minLength;

    public PasswordLengthValidatorImpl(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void validate(String password) {
        if (password.length() < minLength) {
            throw new IllegalArgumentException("Пароль слишком короткий");
        }
    }
}
