package de.ait.timepad.repositories;

import de.ait.timepad.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    Page<User> findAllByRole(User.Role role, Pageable pageable);
    Page<User> findAllByState(User.State state, Pageable pageable);

    // показать всех пользователей, у которых есть статьи в заданном промежутке
    List<User> findAllByArticles_PublishDateBetween(LocalDate from, LocalDate to);
}
