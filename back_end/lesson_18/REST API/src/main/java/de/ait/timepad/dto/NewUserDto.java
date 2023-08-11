package de.ait.timepad.dto;

import de.ait.timepad.validation.constraints.NotWeakPassword;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@Builder
@Schema(description = "Данные для добавления пользователя")
public class NewUserDto {

    @Schema(description = "Email пользователя", example = "simple@mail.com")
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Schema(description = "Пароль пользователя", example = "qwerty007")
    @NotBlank
    @Size(min = 7, max = 1000)
    @NotWeakPassword
    private String password;
}
