package de.ait.timepad.dto;

import lombok.Data;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
public class NewUserDto {
    private String email;
    private String password;
}
