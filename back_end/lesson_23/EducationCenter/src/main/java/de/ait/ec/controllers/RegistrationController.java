package de.ait.ec.controllers;

import de.ait.ec.controllers.api.RegistrationApi;
import de.ait.ec.dto.RegisterDto;
import de.ait.ec.dto.UserDto;
import de.ait.ec.services.RegistrationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * 8/16/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class RegistrationController implements RegistrationApi {

    RegistrationService registrationService;

    @Override
    public ResponseEntity<UserDto> register(RegisterDto registerData) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registrationService.register(registerData));
    }
}
