package de.ait.timepad.validation.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Ошибка валидации")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ValidationErrorDto {

    @Schema(description = "Поле, в котором возникла ошибка", example = "email")
    private String field;

    @Schema(description = "Сообщение об ошибке", example = "must be a well-formed email address")
    private String message;

    @Schema(description = "Какое значение было получено от клиента", example = "sidikov.marsel.com")
    private String rejectedValue;
}
