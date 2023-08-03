package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 7/25/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@Schema(description = "Данные для обновления")
public class UpdateUserDto {

    @Schema(description = "Роль пользователя - USER - пользователь, MANAGER - менеджер", example = "USER")
    private String newRole;

    @Schema(description = "Статус пользователя - NOT_CONFIRMED - не подтвержден, " +
            "CONFIRMED - подтвержден, BANNED - забанен, DELETED - удален", example = "CONFIRMED")
    private String newState;
}
