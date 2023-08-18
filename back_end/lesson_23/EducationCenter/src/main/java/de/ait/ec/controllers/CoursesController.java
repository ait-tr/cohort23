package de.ait.ec.controllers;

import de.ait.ec.controllers.api.CoursesApi;
import de.ait.ec.dto.*;
import de.ait.ec.services.CoursesService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * 8/17/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class CoursesController implements CoursesApi {

    CoursesService coursesService;

    @Override
    public ResponseEntity<CourseDto> addCourse(NewCourseDto newCourse) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(coursesService.addCourse(newCourse));
    }

    @Override
    public ResponseEntity<CourseDto> updateCourse(Long courseId, UpdateCourseDto updateCourse) {
        return ResponseEntity
                .ok()
                .body(coursesService.updateCourse(courseId, updateCourse));
    }

    @Override
    public ResponseEntity<StudentsDto> addStudentToCourse(Long courseId, StudentForCourseDto student) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(coursesService.addStudentToCourse(courseId, student));
    }

    @Override
    public ResponseEntity<StudentsDto> getStudentsOfCourse(Long courseId) {
        return ResponseEntity
                .ok()
                .body(coursesService.getStudentsOfCourse(courseId));
    }

    @Override
    public ResponseEntity<LessonsDto> addLessonToCourse(Long courseId, LessonForCourseDto lesson) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(coursesService.addLessonToCourse(courseId, lesson));
    }

    @Override
    public ResponseEntity<LessonsDto> getLessonsOfCourse(Long courseId) {
        return ResponseEntity.ok()
                .body(coursesService.getLessonsOfCourse(courseId));
    }

    @Override
    public ResponseEntity<CourseDto> getCourse(Long courseId) {
        return ResponseEntity
                .ok()
                .body(coursesService.getCourse(courseId));
    }

    @Override
    public ResponseEntity<CoursesDto> getCourses() {
        return ResponseEntity
                .ok()
                .body(coursesService.getCourses());
    }
}
