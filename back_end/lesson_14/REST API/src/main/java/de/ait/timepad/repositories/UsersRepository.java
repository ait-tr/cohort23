package de.ait.timepad.repositories;

import de.ait.timepad.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersRepository extends JpaRepository<User, Long> {
}
