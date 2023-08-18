package de.ait.ec.controllers;

import de.ait.ec.controllers.api.LessonsApi;
import de.ait.ec.dto.LessonDto;
import de.ait.ec.dto.LessonsDto;
import de.ait.ec.dto.NewLessonDto;
import de.ait.ec.services.LessonsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


/**
 * 8/18/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RestController
public class LessonsController implements LessonsApi {

    LessonsService lessonsService;

    @Override
    public ResponseEntity<LessonDto> addLesson(NewLessonDto lesson) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(lessonsService.addLesson(lesson));
    }

    @Override
    public ResponseEntity<LessonsDto> getAllLessonsNotInCourse() {
        return ResponseEntity
                .ok(lessonsService.getAllLessonsNotInCourse());

    }
}
