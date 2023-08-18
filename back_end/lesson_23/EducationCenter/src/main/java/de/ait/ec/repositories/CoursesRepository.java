package de.ait.ec.repositories;

import de.ait.ec.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 8/16/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface CoursesRepository extends JpaRepository<Course, Long> {
}
