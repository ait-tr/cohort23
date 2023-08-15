package de.ait.timepad.repositories;

import de.ait.timepad.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    Page<User> findAllByRole(User.Role role, Pageable pageable);
    Page<User> findAllByState(User.State state, Pageable pageable);

    Optional<User> findByEmail(String email);

    // JPQL
    @Query(value = "select distinct user from User user left join user.articles article where article.state = 'PUBLISHED'")
    Page<User> findAllWithPublishedArticles(Pageable pageable);
}
