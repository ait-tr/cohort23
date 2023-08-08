package de.ait.timepad.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
@Schema(description = "Ошибки валидации")
public class ValidationErrorsDto {

    @Schema(description = "Список ошибок")
    private List<ValidationErrorDto> errors; // список возникших ошибок
}
