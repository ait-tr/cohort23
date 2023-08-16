package de.ait.timepad.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 8/12/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Запрос пользователей")
public class UsersRequest {
    @Parameter(description = "Номер страницы", example = "1")
    private Integer page;
    @Parameter(description = "Поле, по которому хотим выполнять сортировку. Доступно: email, role, state, id")
    private String orderBy;
    @Parameter(description = "Указать true, если необходимо сортировать в обратном порядке")
    private Boolean desc;
    private String filterBy;
    private String filterValue;
    private String articles;
}
