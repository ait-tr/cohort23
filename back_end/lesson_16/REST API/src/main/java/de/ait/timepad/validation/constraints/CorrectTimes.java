package de.ait.timepad.validation.constraints;

import de.ait.timepad.validation.validators.EventTimesValidator;
import de.ait.timepad.validation.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EventTimesValidator.class)
public @interface CorrectTimes {

    String message() default "startTime must be earlier than finishTime";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
