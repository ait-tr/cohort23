package de.ait.ec.handler;

import org.springframework.http.HttpStatus;

/**
 * 8/9/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class RestException extends RuntimeException {

    private final HttpStatus httpStatus;

    public RestException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
