package de.ait.validators.impl;

import de.ait.validators.EmailValidator;

/**
 * 7/19/2023
 * Spring Demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class EmailValidatorSimpleImpl implements EmailValidator {
    @Override
    public void validate(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email не содержит @");
        }
    }
}
