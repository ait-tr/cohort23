package de.ait.timepad.services;

import de.ait.timepad.dto.*;
import de.ait.timepad.dto.pages.ArticlesDto;
import de.ait.timepad.dto.pages.UsersDto;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers(UsersRequest request);

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);

    UserDto getUser(Long userId);

    ArticlesDto getArticlesOfUser(Long userId);

    ArticlesDto getPublishedArticlesArticlesOfUser(Integer pageNumber, Long userId);
}
