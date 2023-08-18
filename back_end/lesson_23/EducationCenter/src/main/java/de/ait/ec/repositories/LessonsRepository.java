package de.ait.ec.repositories;

import de.ait.ec.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonsRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByCourseIsNull();
}
