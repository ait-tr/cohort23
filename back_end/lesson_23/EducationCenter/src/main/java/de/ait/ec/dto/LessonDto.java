package de.ait.ec.dto;

import de.ait.ec.models.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 8/18/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDto {

    private Long id;

    private String name;

    private String dayOfWeek;

    private String startTime;

    private String finishTime;

    private Long courseId;

    public static LessonDto from(Lesson lesson) {
        LessonDto result = LessonDto.builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .dayOfWeek(lesson.getDayOfWeek().toString())
                .startTime(lesson.getStartTime().toString())
                .finishTime(lesson.getFinishTime().toString())
                .build();

        if (lesson.getCourse() != null) {
            result.setCourseId(lesson.getCourse().getId());
        }

        return result;
    }

    public static List<LessonDto> from(Collection<Lesson> lessons) {
        return lessons.stream()
                .map(LessonDto::from)
                .collect(Collectors.toList());
    }
}
