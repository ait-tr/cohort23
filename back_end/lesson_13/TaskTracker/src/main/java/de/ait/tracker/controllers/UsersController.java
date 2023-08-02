package de.ait.tracker.controllers;

import de.ait.tracker.controllers.api.UsersApi;
import de.ait.tracker.dto.NewUserDto;
import de.ait.tracker.dto.UserDto;
import de.ait.tracker.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 8/1/2023
 * TaskTracker
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

    private final UsersService usersService;

    @Override
    public List<UserDto> getAllUsers() {
        return usersService.getAllUsers();
    }

    @Override
    public UserDto addUser(NewUserDto userDto) {
        return usersService.addUser(userDto);
    }
}
