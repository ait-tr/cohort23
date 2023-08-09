package de.ait.timepad.services;

import de.ait.timepad.dto.*;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers(Integer pageNumber, String orderByField, Boolean desc, String filterBy, String filterValue);

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);

    UserDto getUser(Long userId);

    ArticlesDto getArticlesOfUser(Long userId);
}
