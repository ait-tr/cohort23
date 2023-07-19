package de.ait.services;

import de.ait.models.User;

import java.util.List;

public interface UsersService {
    void signUp(String email, String password);
    List<User> getAllUsers();
}
