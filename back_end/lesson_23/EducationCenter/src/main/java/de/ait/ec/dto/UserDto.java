package de.ait.ec.dto;

import de.ait.ec.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Пользователь системы")
public class UserDto {

    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long id;

    @Schema(description = "Email пользователя", example = "simple@mail.com" )
    private String email;

    @Schema(description = "Роль пользователя - ADMIN - администратор, USER - пользователь, MANAGER - менеджер", example = "ADMIN")
    private String role;

    @Schema(description = "Статус пользователя - " +
            "CONFIRMED - подтвержден, BANNED - забанен, DELETED - удален", example = "CONFIRMED")
    private String state;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .state(user.getState().name())
                .role(user.getRole().name())
                .build();
    }

    public static List<UserDto> from(Collection<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
