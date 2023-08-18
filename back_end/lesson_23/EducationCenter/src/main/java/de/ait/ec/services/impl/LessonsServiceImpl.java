package de.ait.ec.services.impl;

import de.ait.ec.dto.LessonDto;
import de.ait.ec.dto.LessonsDto;
import de.ait.ec.dto.NewLessonDto;
import de.ait.ec.models.Lesson;
import de.ait.ec.repositories.LessonsRepository;
import de.ait.ec.services.LessonsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static de.ait.ec.dto.LessonDto.from;

/**
 * 8/18/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class LessonsServiceImpl implements LessonsService {

    LessonsRepository lessonsRepository;

    @Transactional
    @Override
    public LessonDto addLesson(NewLessonDto lesson) {
        Lesson newLesson = Lesson.builder()
                .name(lesson.getName())
                .startTime(LocalTime.parse(lesson.getStartTime()))
                .finishTime(LocalTime.parse(lesson.getFinishTime()))
                .dayOfWeek(DayOfWeek.valueOf(lesson.getDayOfWeek()))
                .build();

        lessonsRepository.save(newLesson);

        return from(newLesson);
    }

    @Override
    public LessonsDto getAllLessonsNotInCourse() {
        List<Lesson> lessons = lessonsRepository.findAllByCourseIsNull();

        return LessonsDto.builder()
                .lessons(from(lessons))
                .build();
    }
}
