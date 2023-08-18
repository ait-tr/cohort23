package de.ait.ec.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 8/17/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
public class StudentForCourseDto {

    @NotNull
    private Long studentId;
}
