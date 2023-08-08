package de.ait.timepad.handler;

import de.ait.timepad.dto.ErrorDto;
import de.ait.timepad.exceptions.ForbiddenUpdateUserOperationException;
import de.ait.timepad.exceptions.IncorrectUserIdException;
import de.ait.timepad.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 8/8/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler(IncorrectUserIdException.class) // какой класс ошибок перехватываем
    public ResponseEntity<ErrorDto> handleIncorrectUserIdException(IncorrectUserIdException e) { // что именно перехватили
        return ResponseEntity // сформировали ответ
                .status(HttpStatus.UNPROCESSABLE_ENTITY) // прописываем статус ответа
                .body(ErrorDto.builder() // собираем ответ
                        .message("Id of user <" + e.getId() + "> is incorrect.")
                        .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(NotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ErrorDto.builder() // собираем ответ
                        .message(e.getEntity() + " with id <" + e.getId() + "> not found.")
                        .build());
    }

    @ExceptionHandler(ForbiddenUpdateUserOperationException.class)
    public ResponseEntity<ErrorDto> handleException(ForbiddenUpdateUserOperationException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(ErrorDto.builder() // собираем ответ
                        .message("Cannot set <" + e.getField() + "> as <" + e.getNewValue() + ">")
                        .build());
    }
}
