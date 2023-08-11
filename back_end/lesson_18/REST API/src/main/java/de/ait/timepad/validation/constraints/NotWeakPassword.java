package de.ait.timepad.validation.constraints;

import de.ait.timepad.validation.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // на что ее можно вешать - на поле
@Retention(RetentionPolicy.RUNTIME) // что аннотация не будет удалена в момент работы приложения
@Constraint(validatedBy = PasswordValidator.class) // чем валидируется
public @interface NotWeakPassword {

    String message() default "must be strong";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
