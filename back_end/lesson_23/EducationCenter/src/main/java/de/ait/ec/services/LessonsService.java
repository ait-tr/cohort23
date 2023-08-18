package de.ait.ec.services;

import de.ait.ec.dto.LessonDto;
import de.ait.ec.dto.LessonsDto;
import de.ait.ec.dto.NewLessonDto;

public interface LessonsService {
    LessonDto addLesson(NewLessonDto lesson);

    LessonsDto getAllLessonsNotInCourse();
}
