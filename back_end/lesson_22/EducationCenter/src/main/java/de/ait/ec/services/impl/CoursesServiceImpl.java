package de.ait.ec.services.impl;

import de.ait.ec.dto.*;
import de.ait.ec.handler.RestException;
import de.ait.ec.models.Course;
import de.ait.ec.models.User;
import de.ait.ec.repositories.CoursesRepository;
import de.ait.ec.repositories.UsersRepository;
import de.ait.ec.services.CoursesService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;

import static de.ait.ec.dto.CourseDto.from;
import static de.ait.ec.dto.UserDto.from;

/**
 * 8/17/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Service
public class CoursesServiceImpl implements CoursesService {

    CoursesRepository coursesRepository;

    UsersRepository usersRepository;

    UsersServiceImpl usersService;

    @Transactional
    @Override
    public CourseDto addCourse(NewCourseDto newCourse) {
        Course course = Course.builder()
                .startDate(LocalDate.parse(newCourse.getStartDate()))
                .finishDate(LocalDate.parse(newCourse.getFinishDate()))
                .title(newCourse.getTitle())
                .description(newCourse.getDescription())
                .build();

        coursesRepository.save(course);

        return from(course);
    }

    @Transactional
    @Override
    public CourseDto updateCourse(Long courseId, UpdateCourseDto updateCourse) {

        Course course = getCourseOrThrow(courseId);

        course.setDescription(updateCourse.getDescription());

        if (updateCourse.getStartDate() != null) {
            course.setStartDate(LocalDate.parse(updateCourse.getStartDate()));
        }

        if (updateCourse.getFinishDate() != null) {
            course.setFinishDate(LocalDate.parse(updateCourse.getFinishDate()));
        }

        coursesRepository.save(course);

        return from(course);
    }

    @Override
    public StudentsDto addStudentToCourse(Long courseId, StudentForCourseDto studentId) {
        Course course = getCourseOrThrow(courseId);

        User student = usersService.getUserOrThrow(studentId.getStudentId());

        student.getCourses().add(course);

        usersRepository.save(student);

        return getStudents(course);
    }

    private static StudentsDto getStudents(Course course) {
        return StudentsDto.builder()
                .students(from(course.getStudents().stream()
                        .sorted(Comparator.comparing(User::getId))
                        .collect(Collectors.toList())))
                .build();
    }

    @Override
    public StudentsDto getStudentsOfCourse(Long courseId) {
        Course course = getCourseOrThrow(courseId);

        return getStudents(course);


    }

    @Override
    public CourseDto getCourse(Long courseId) {
        return from(getCourseOrThrow(courseId));
    }

    @Override
    public CoursesDto getCourses() {
        return CoursesDto.builder()
                .courses(from(coursesRepository.findAll()))
                .build();
    }

    Course getCourseOrThrow(Long courseId) {
        return coursesRepository.findById(courseId).orElseThrow(
                () -> new RestException(HttpStatus.NOT_FOUND, "Course with id <" + courseId + "> not found"));
    }

}
