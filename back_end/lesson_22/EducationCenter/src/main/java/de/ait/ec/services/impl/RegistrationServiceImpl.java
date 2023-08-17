package de.ait.ec.services.impl;

import de.ait.ec.dto.RegisterDto;
import de.ait.ec.dto.UserDto;
import de.ait.ec.models.User;
import de.ait.ec.repositories.UsersRepository;
import de.ait.ec.services.RegistrationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static de.ait.ec.dto.UserDto.from;

/**
 * 8/16/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

    UsersRepository usersRepository;

    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserDto register(RegisterDto registerData) {
        User user = User.builder()
                .email(registerData.getEmail())
                .hashPassword(passwordEncoder.encode(registerData.getPassword()))
                .role(User.Role.STUDENT)
                .state(User.State.CONFIRMED).build();

        usersRepository.save(user);

        return from(user);
    }
}
