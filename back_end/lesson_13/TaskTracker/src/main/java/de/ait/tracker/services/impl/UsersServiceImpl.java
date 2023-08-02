package de.ait.tracker.services.impl;

import de.ait.tracker.dto.NewUserDto;
import de.ait.tracker.dto.UserDto;
import de.ait.tracker.models.User;
//import de.ait.tracker.repositories.UsersRepository;
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

//    private final UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
//        return from(usersRepository.findAll());
        return null;
    }

    @Override
    public UserDto addUser(NewUserDto userDto) {

        User user = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .build();

//        usersRepository.save(user);

        return from(user);
    }
}
