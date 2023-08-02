package de.ait.tracker.services.impl;

import de.ait.tracker.dto.UserDto;
import de.ait.tracker.repositories.UsersRepository;
import de.ait.tracker.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.tracker.dto.UserDto.from;

/**
 * 8/1/2023
 * TaskTracker
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return from(usersRepository.findAll());
    }
}
