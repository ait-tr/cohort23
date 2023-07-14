import repositories.impl.UsersRepositoryFileImpl;
import repositories.impl.UsersRepositoryListImpl;
import services.UsersService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // приложение для регистрации пользователя
        // а что если мы хотим пользователей хранить не в списке, а в файле?
        // а что, если мы хотим проверять пароли, например, на длину?
        // а что, если мы хотим проверять email, например, на наличие @?
        // код станет слишком большим, мы начнем теряться
        // Решение 1 - разбить на методы
        // Решение 2 - применить архитектурный подход - будем все разбивать на слои и делать так, чтобы они не зависели друг от друга
        Scanner scanner = new Scanner(System.in);

        UsersRepositoryListImpl repositoryList = new UsersRepositoryListImpl();
        UsersRepositoryFileImpl repositoryFile = new UsersRepositoryFileImpl();
        UsersService usersService = new UsersService(repositoryFile);

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