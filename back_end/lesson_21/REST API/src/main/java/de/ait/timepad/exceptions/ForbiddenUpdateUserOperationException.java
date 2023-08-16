package de.ait.timepad.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 7/25/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class ForbiddenUpdateUserOperationException extends RestException {

    public ForbiddenUpdateUserOperationException(String field, String newValue) {
        super(HttpStatus.FORBIDDEN, "Cannot set <" + field + "> as <" + newValue + ">");
    }

}
