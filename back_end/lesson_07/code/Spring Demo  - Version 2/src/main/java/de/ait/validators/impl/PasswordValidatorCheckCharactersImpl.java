package de.ait.validators.impl;

import de.ait.validators.PasswordValidator;

import java.util.List;

/**
 * 7/19/2023
 * Spring Demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class PasswordValidatorCheckCharactersImpl implements PasswordValidator {

    private List<Character> characters;
    @Override
    public void validate(String password) {
        if (characters != null) {
            for (char character : characters) {
                if (password.indexOf(character) == -1) {
                    throw new IllegalArgumentException("Пароль не содержит специального символа " + character);
                }
            }
        }
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
