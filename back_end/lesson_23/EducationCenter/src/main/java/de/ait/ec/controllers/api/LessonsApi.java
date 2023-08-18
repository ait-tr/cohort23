package de.ait.ec.controllers.api;

import de.ait.ec.dto.LessonDto;
import de.ait.ec.dto.LessonsDto;
import de.ait.ec.dto.NewLessonDto;
import de.ait.ec.dto.UsersDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 8/18/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequestMapping("/api/lessons")
@Tags(value =
@Tag(name = "Lessons")
)
public interface LessonsApi {

    //
    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @PostMapping
    ResponseEntity<LessonDto> addLesson(@RequestBody @Valid NewLessonDto lesson);

    //
    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @GetMapping("/withoutCourse")
    ResponseEntity<LessonsDto> getAllLessonsNotInCourse();
}
