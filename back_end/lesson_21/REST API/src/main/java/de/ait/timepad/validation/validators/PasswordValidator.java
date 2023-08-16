package de.ait.timepad.validation.validators;

import de.ait.timepad.validation.constraints.NotWeakPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8/3/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class PasswordValidator implements ConstraintValidator<NotWeakPassword, String> {

    private static final Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        // проверяем строку по шаблону (pattern-у, регулярному выражению)
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
