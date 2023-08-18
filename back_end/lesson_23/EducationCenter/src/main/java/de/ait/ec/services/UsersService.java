package de.ait.ec.services;

import de.ait.ec.dto.UserDto;
import de.ait.ec.dto.UsersDto;

/**
 * 8/16/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersService {
    UserDto getUser(Long userId);

    UsersDto getAllStudentsNotInCourse(Long courseId);

    UserDto deleteUser(Long userId);
}
