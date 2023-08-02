package de.ait.tracker.services;

import de.ait.tracker.dto.NewUserDto;
import de.ait.tracker.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();

    UserDto addUser(NewUserDto userDto);
}
