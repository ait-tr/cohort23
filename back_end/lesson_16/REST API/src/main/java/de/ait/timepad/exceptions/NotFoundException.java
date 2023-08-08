package de.ait.timepad.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 7/25/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class NotFoundException extends RuntimeException {

    private final String entity;
    private final Long id;

    public NotFoundException(String entity, Long id) {
        super();
        this.entity = entity;
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public Long getId() {
        return id;
    }
}
