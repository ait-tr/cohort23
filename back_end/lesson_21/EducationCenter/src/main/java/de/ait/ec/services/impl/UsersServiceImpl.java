package de.ait.ec.services.impl;

import de.ait.ec.dto.UserDto;
import de.ait.ec.handler.RestException;
import de.ait.ec.models.User;
import de.ait.ec.repositories.UsersRepository;
import de.ait.ec.services.UsersService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    private User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new RestException(HttpStatus.NOT_FOUND, "User with id <" + userId + "> not found"));
    }
}
