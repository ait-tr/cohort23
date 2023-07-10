package de.aittr.MVCdemo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    List<User> getAllUsers(){
        return repository.findAll();
    }

}
