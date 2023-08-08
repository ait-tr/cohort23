package de.ait.timepad.validation.validators;

import de.ait.timepad.dto.NewEventDto;
import de.ait.timepad.validation.constraints.CorrectTimes;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

/**
 * 8/8/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class EventTimesValidator implements ConstraintValidator<CorrectTimes, NewEventDto> {

    @Override
    public boolean isValid(NewEventDto eventDto, ConstraintValidatorContext constraintValidatorContext) {
        try {
            LocalTime startTime = LocalTime.parse(eventDto.getStartTime());
            LocalTime finishTime = LocalTime.parse(eventDto.getFinishTime());

            return startTime.isBefore(finishTime);
        } catch (RuntimeException e) {
            return false;
        }
    }
}
