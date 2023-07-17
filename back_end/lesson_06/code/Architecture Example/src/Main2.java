import models.User;
import repositories.impl.UsersRepositoryFileImpl;

/**
 * 7/14/2023
 * Architecture Example
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main2 {
    public static void main(String[] args) {
        UsersRepositoryFileImpl usersRepository = new UsersRepositoryFileImpl();
        User user = new User("marsel@gmail.com", "qwerty007");
        usersRepository.save(user);
    }
}
