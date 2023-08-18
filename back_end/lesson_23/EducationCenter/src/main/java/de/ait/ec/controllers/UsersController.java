package de.ait.ec.controllers;

import de.ait.ec.controllers.api.UsersApi;
import de.ait.ec.dto.UserDto;
import de.ait.ec.dto.UsersDto;
import de.ait.ec.security.details.AuthenticatedUser;
import de.ait.ec.services.UsersService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * 8/16/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

    UsersService usersService;

    @Override
    public ResponseEntity<UserDto> getMyProfile(AuthenticatedUser currentUser) {
        Long userId = currentUser.id();
        return ResponseEntity.ok(usersService.getUser(userId));
    }

    @Override
    public ResponseEntity<UserDto> deleteMyProfile(AuthenticatedUser currentUser) {
        Long userId = currentUser.id();
        return ResponseEntity.ok(usersService.deleteUser(userId));
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(Long userId) {
        return ResponseEntity.ok(usersService.deleteUser(userId));
    }

    @Override
    public ResponseEntity<UsersDto> getAllStudentsNotInCourse(Long courseId) {
        return ResponseEntity
                .ok(usersService.getAllStudentsNotInCourse(courseId));
    }
}
