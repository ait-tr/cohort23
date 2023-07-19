import de.ait.config.ApplicationConfig;
import de.ait.services.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * 7/19/2023
 * Spring Demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UsersService usersService = context.getBean(UsersService.class);

        Scanner scanner = new Scanner(System.in);

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
