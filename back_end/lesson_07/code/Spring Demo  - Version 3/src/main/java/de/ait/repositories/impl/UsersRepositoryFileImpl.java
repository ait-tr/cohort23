package de.ait.repositories.impl;

import de.ait.repositories.UsersRepository;
import de.ait.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 7/14/2023
 * Architecture Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Repository
public class UsersRepositoryFileImpl implements UsersRepository {

    private final String fileName;

    public UsersRepositoryFileImpl(@Value("${file.name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(user.getEmail() + "#" + user.getPassword());
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }

    @Override
    public List<User> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(line -> line.split("#"))// разбил строки по #
                    .map(array -> new User(array[0], array[1]))// превратил массив строк в объект
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Проблемы с файлом");
        }
    }
}
