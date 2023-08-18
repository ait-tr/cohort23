package de.ait.ec.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 8/18/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
public class NewLessonDto {

    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    private String dayOfWeek;

    @NotNull
    @NotBlank
    @NotEmpty
    private String startTime;

    @NotNull
    @NotBlank
    @NotEmpty
    private String finishTime;
}
