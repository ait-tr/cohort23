package de.ait.ec.services.impl;

import de.ait.ec.dto.UserDto;
import de.ait.ec.dto.UsersDto;
import de.ait.ec.handler.RestException;
import de.ait.ec.models.Course;
import de.ait.ec.models.User;
import de.ait.ec.repositories.CoursesRepository;
import de.ait.ec.repositories.UsersRepository;
import de.ait.ec.security.details.AuthenticatedUser;
import de.ait.ec.services.UsersService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static de.ait.ec.dto.UserDto.from;

/**
 * 8/16/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;
    CoursesRepository coursesRepository;

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    @Override
    public UsersDto getAllStudentsNotInCourse(Long courseId) {
        Course course = coursesRepository.findById(courseId).orElseThrow(
                () -> new RestException(HttpStatus.NOT_FOUND, "Course with id <" + courseId + "> not found"));

        return UsersDto.builder()
                .students(from(usersRepository.findStudentsNotInCourse(course)))
                .build();
    }

    @Transactional
    @Override
    public UserDto deleteUser(Long userId) {
        User user = getUserOrThrow(userId);

        user.setState(User.State.DELETED);

        if (user.getRole().equals(User.Role.STUDENT)) {
            user.getCourses().clear();
        }

        usersRepository.save(user);

        logoutIfNecessary(userId);

        return from(user);
    }

    private void logoutIfNecessary(Long userIdForLogout) {
        // объект аутентификации текущего пользователя
        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication());
        // нашли текущего пользователя по email
        User currentUser = usersRepository.findByEmail(token.getName()).orElseThrow();
        // если мы удаляем себя
        if (currentUser.getId().equals(userIdForLogout)) {
            // завершаем свою сессию
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

    User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new RestException(HttpStatus.NOT_FOUND, "User with id <" + userId + "> not found"));
    }
}
