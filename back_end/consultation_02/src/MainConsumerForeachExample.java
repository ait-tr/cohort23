import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 7/24/2023
 * cohort23
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class MainConsumerForeachExample {
    public static void main(String[] args) {
        Human h1 = new Human("Marsel", false);
        Human h2 = new Human("Vadim", false);
        Human h3 = new Human("Yana", false);

        Stream<Human> humans = Stream.of(h1, h2 , h3);

        Consumer<Human> goToWork = human -> human.setWork(true);

        humans.forEach(goToWork);

        System.out.println(h1.isWork());
        System.out.println(h2.isWork());
        System.out.println(h3.isWork());
    }
}
