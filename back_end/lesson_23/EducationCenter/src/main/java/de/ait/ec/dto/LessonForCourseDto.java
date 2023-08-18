package de.ait.ec.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 8/18/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
public class LessonForCourseDto {

    @NotNull
    private Long lessonId;
}
