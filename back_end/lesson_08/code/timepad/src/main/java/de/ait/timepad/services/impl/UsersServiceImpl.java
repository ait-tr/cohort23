package de.ait.timepad.services.impl;

import de.ait.timepad.dto.NewUserDto;
import de.ait.timepad.dto.UserDto;
import de.ait.timepad.dto.UsersDto;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.UsersRepository;
import de.ait.timepad.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static de.ait.timepad.dto.UserDto.from;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public UserDto addUser(NewUserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .role(User.Role.USER)
                .state(User.State.NOT_CONFIRMED).build();

        usersRepository.save(user);

        return from(user);
    }

    @Override
    public UsersDto getAllUsers() {
//        List<User> users = usersRepository.findAll();
//
//        List<UserDto> dtos = new ArrayList<>();
//
//        for (User user : users) {
//            UserDto userDto = from(user);
//            dtos.add(userDto);
//        }
        List<User> users = usersRepository.findAll();
        return UsersDto.builder()
                .users(from(users))
                .count(users.size())
                .build();
    }
}
