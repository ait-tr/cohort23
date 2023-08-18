package de.ait.ec.services;

import de.ait.ec.dto.RegisterDto;
import de.ait.ec.dto.UserDto;

/**
 * 8/16/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface RegistrationService {
    UserDto register(RegisterDto registerData);
}
