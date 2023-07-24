import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 7/24/2023
 * cohort23
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main5 {
    public static void main(String[] args) {
       try (BufferedReader reader = new BufferedReader(new FileReader("cars.txt"))) {

//           reader.lines().map().filter().mapToInt().average();

       } catch (IOException e) {
           throw new IllegalArgumentException(e);
       }
    }
}
