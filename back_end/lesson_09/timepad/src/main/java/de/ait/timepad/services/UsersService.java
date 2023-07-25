package de.ait.timepad.services;

import de.ait.timepad.dto.NewUserDto;
import de.ait.timepad.dto.UpdateUserDto;
import de.ait.timepad.dto.UserDto;
import de.ait.timepad.dto.UsersDto;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers();

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);

    UserDto getUser(Long userId);
}
