package de.ait.timepad.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 7/28/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidationErrorDto {
    private String field; // с каким полем возникла ошибка
    private String message; // сообщение об ошибке
    private String rejectedValue; // какое значение от клиента было плохим
}
