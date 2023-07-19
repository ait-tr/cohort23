package de.ait.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 7/14/2023
 * Architecture Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data // toString, equals, hashCode, getters, setter
@NoArgsConstructor // конструктор без параметров
@AllArgsConstructor // конструктор с параметрами
public class User {

    private String email;
    private String password;

}
