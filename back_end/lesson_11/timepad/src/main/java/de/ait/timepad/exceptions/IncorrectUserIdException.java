package de.ait.timepad.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class IncorrectUserIdException extends RuntimeException {
    public IncorrectUserIdException(String message) {
        super(message);
    }
}
