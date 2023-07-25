package de.ait.timepad.services.impl;

import de.ait.timepad.dto.NewUserDto;
import de.ait.timepad.dto.UpdateUserDto;
import de.ait.timepad.dto.UserDto;
import de.ait.timepad.dto.UsersDto;
import de.ait.timepad.exceptions.ForbiddenOperationException;
import de.ait.timepad.exceptions.NotFoundException;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.UsersRepository;
import de.ait.timepad.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public UserDto deleteUser(Long userId) {
//        Optional<User> user = usersRepository.findById(userId);
//
//        if (user.isEmpty()) {
//            throw new NotFoundException("User with id <" + userId + "> not found");
//        }
//
//        usersRepository.delete(user.get());
        User user = getUserOrThrow(userId);

        usersRepository.delete(user);

        return from(user);
    }

    @Override
    public UserDto updateUser(Long userId, UpdateUserDto updateUser) {

        User user = getUserOrThrow(userId); // нашли пользователя

        if (updateUser.getNewRole().equals("ADMIN")) {
            throw new ForbiddenOperationException("Cannot make an administrator");
        }

        // обновляем ему поля
        user.setState(User.State.valueOf(updateUser.getNewState()));
        user.setRole(User.Role.valueOf(updateUser.getNewRole()));

        usersRepository.save(user); // вместо отдельно update можно использовать save

        return from(user); // возвращаем обновленного пользователя
    }

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }

    private User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User with id <" + userId + "> not found"));
    }
}
