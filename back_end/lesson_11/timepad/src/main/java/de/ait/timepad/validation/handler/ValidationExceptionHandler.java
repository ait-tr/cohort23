package de.ait.timepad.validation.handler;

import de.ait.timepad.validation.dto.ValidationErrorDto;
import de.ait.timepad.validation.dto.ValidationErrorsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 7/28/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorsDto> handleException(MethodArgumentNotValidException e) {
        List<ValidationErrorDto> validationErrors = new ArrayList<>();
        // e - исключение, содержит информацию обо всех ошибках, которые произошли в момент запроса с NewUserDto
        BindingResult bindingResult = e.getBindingResult(); // получаем результаты валидации
        List<ObjectError> errors = bindingResult.getAllErrors(); // получаем все ошибки валидации
        // пробежим по всем ошибкам и распечатаем их отдельно
        for (ObjectError error : errors) {
            FieldError fieldError = (FieldError)error; // если ошибка связана с конкретным полем, то будем работать с полем
            // собрали JSON для клиента с одной ошибкой
            ValidationErrorDto errorDto = ValidationErrorDto.builder()
                    .field(fieldError.getField())
                    .message(error.getDefaultMessage())
                    .rejectedValue(fieldError.getRejectedValue().toString())
                    .build();

            validationErrors.add(errorDto); // кладем ошибку в общий список
        }
        // подготовили тело ответа
        ValidationErrorsDto body =  ValidationErrorsDto.builder()
                .errors(validationErrors)
                .build();

        // создали ответ
        ResponseEntity<ValidationErrorsDto> response = new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
        // вернули ответ
        return response;
    }
}
