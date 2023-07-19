package de.ait;

import de.ait.repositories.impl.UsersRepositoryFileImpl;
import de.ait.repositories.impl.UsersRepositoryListImpl;
import de.ait.services.UsersServiceImpl;
import de.ait.validators.impl.EmailValidatorRegexImpl;
import de.ait.validators.impl.EmailValidatorSimpleImpl;
import de.ait.validators.impl.PasswordLengthValidatorImpl;
import de.ait.validators.impl.PasswordValidatorCheckCharactersImpl;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UsersRepositoryListImpl repositoryList = new UsersRepositoryListImpl();
        UsersRepositoryFileImpl repositoryFile = new UsersRepositoryFileImpl();
        EmailValidatorRegexImpl emailValidatorRegex = new EmailValidatorRegexImpl("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        EmailValidatorSimpleImpl emailValidatorSimple = new EmailValidatorSimpleImpl();
        PasswordLengthValidatorImpl passwordLengthValidator = new PasswordLengthValidatorImpl(5);
        PasswordValidatorCheckCharactersImpl passwordValidatorCheckCharacters = new PasswordValidatorCheckCharactersImpl();
        passwordValidatorCheckCharacters.setCharacters(Arrays.asList('%', '!', '+', '?'));

        UsersServiceImpl usersService = new UsersServiceImpl(repositoryFile, emailValidatorRegex, passwordValidatorCheckCharacters);

        while (true) {
            System.out.println("1. Зарегистрировать пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("0. Выход");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> {
                    String email = scanner.nextLine();
                    String password = scanner.nextLine();

                    usersService.signUp(email, password);
                }
                case 2 -> System.out.println(usersService.getAllUsers());
                case 0 -> System.exit(0);
            }
        }
    }
}