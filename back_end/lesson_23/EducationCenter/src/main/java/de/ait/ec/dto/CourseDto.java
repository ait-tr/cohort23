package de.ait.ec.dto;


import de.ait.ec.models.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 8/17/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {

    private Long id;

    private String title;

    private String description;

    private String startDate;

    private String finishDate;

    public static CourseDto from(Course course) {
        CourseDto result =  builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .build();

        if (course.getStartDate() != null) {
            result.setStartDate(course.getStartDate().toString());
        }

        if (course.getFinishDate() != null) {
            result.setFinishDate(course.getFinishDate().toString());
        }

        return result;
    }

    public static List<CourseDto> from(List<Course> courses) {
        return courses.stream()
                .map(CourseDto::from)
                .collect(Collectors.toList());
    }

}
