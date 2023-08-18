package de.ait.ec.controllers.api;

import de.ait.ec.dto.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 8/17/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequestMapping("/api/courses")
@Tags(value =
@Tag(name = "Courses")
)
public interface CoursesApi {

    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @PostMapping
    ResponseEntity<CourseDto> addCourse(@RequestBody @Valid NewCourseDto newCourse);

    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @PutMapping("/{course-id}")
    ResponseEntity<CourseDto> updateCourse(@PathVariable("course-id") Long courseId,
                                           @RequestBody @Valid UpdateCourseDto updateCourse);

    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @PostMapping("/{course-id}/students")
    ResponseEntity<StudentsDto> addStudentToCourse(@PathVariable("course-id") Long courseId,
                                                   @RequestBody @Valid StudentForCourseDto student);

    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @GetMapping("/{course-id}/students")
    ResponseEntity<StudentsDto> getStudentsOfCourse(@PathVariable("course-id") Long courseId);

    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @PostMapping("/{course-id}/lessons")
    ResponseEntity<LessonsDto> addLessonToCourse(@PathVariable("course-id") Long courseId,
                                                   @RequestBody @Valid LessonForCourseDto lesson);

    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @GetMapping("/{course-id}/lessons")
    ResponseEntity<LessonsDto> getLessonsOfCourse(@PathVariable("course-id") Long courseId);

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{course-id}")
    ResponseEntity<CourseDto> getCourse(@PathVariable("course-id") Long courseId);

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    ResponseEntity<CoursesDto> getCourses();
}
