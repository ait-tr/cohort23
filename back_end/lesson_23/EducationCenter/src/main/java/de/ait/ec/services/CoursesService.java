package de.ait.ec.services;

import de.ait.ec.dto.*;

public interface CoursesService {
    CourseDto addCourse(NewCourseDto newCourse);

    CourseDto updateCourse(Long courseId, UpdateCourseDto newCourse);

    StudentsDto addStudentToCourse(Long courseId, StudentForCourseDto student);

    StudentsDto getStudentsOfCourse(Long courseId);

    CourseDto getCourse(Long courseId);

    CoursesDto getCourses();

    LessonsDto addLessonToCourse(Long courseId, LessonForCourseDto lesson);

    LessonsDto getLessonsOfCourse(Long courseId);
}
