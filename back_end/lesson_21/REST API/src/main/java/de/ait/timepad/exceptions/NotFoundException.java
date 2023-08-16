package de.ait.timepad.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 7/25/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class NotFoundException extends RestException {

    public NotFoundException(String entity, Long id) {
        super(HttpStatus.NOT_FOUND, entity + " with id <" + id + "> not found.");
    }
}
