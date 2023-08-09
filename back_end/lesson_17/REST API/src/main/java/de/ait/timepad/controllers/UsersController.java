package de.ait.timepad.controllers;

import de.ait.timepad.controllers.api.UsersApi;
import de.ait.timepad.dto.*;
import de.ait.timepad.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

    private final UsersService usersService;

    @Override
    public ResponseEntity<UserDto> addUser(NewUserDto newUser) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersService.addUser(newUser));
    }

    @Override
    public ResponseEntity<UsersDto> getAllUsers(Integer pageNumber,
                                                String orderBy,
                                                Boolean desc,
                                                String filterBy,
                                                String filterValue) {
        return ResponseEntity
                .ok(usersService.getAllUsers(pageNumber, orderBy, desc, filterBy, filterValue));
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(Long userId) {
        return ResponseEntity
                .ok(usersService.deleteUser(userId));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(Long userId, UpdateUserDto updateUser) {
        return ResponseEntity
                .ok(usersService.updateUser(userId, updateUser));
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity
                .ok(usersService.getUser(userId));
    }

    @Override
    public ResponseEntity<ArticlesDto> getArticlesOfUser(Long userId) {
        return ResponseEntity
                .ok(usersService.getArticlesOfUser(userId));
    }
}
