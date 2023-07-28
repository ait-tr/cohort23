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
    public UsersDto getAllUsers() {
        return usersService.getAllUsers();
    }

    @Override
    public UserDto deleteUser(Long userId) {
        return usersService.deleteUser(userId);
    }

    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {
        return usersService.updateUser(userId, updateUser);
    }

    @Override
    public UserDto getUser(Long userId) {
        return usersService.getUser(userId);
    }

    @Override
    public ArticlesDto getArticlesOfUser(Long userId) {
        return usersService.getArticlesOfUser(userId);
    }
}
