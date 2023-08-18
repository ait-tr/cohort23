package de.ait.ec.handler;

import de.ait.ec.dto.StandardResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

/**
 * 8/8/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<StandardResponseDto> handleRestException(RestException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(StandardResponseDto.builder()
                        .message(e.getMessage())
                        .build());
    }
}
