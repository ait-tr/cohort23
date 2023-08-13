package de.ait.timepad.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 7/27/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class IncorrectUserIdException extends RestException {

    public IncorrectUserIdException(Long incorrectId) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, "Id of user <" + incorrectId + "> is incorrect.");
    }
}
