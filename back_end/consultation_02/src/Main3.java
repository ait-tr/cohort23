import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 7/24/2023
 * cohort23
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main3 {
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>();
        wordsList.add("Hello");
        wordsList.add("Bye");
        wordsList.add("Marsel");
        wordsList.add("Java");
        wordsList.add("String");
        wordsList.add("SQL");

        // получаем "поток данных" - Stream

        Stream<String> words = wordsList.stream();

        // filter - выбирает только те слова, которые нам нужны

        Predicate<String> lengthPredicate = word -> word.length() > 3; // true - слово больше 3-х, false - меньше 3-х

        Stream<String> filteredWords = words.filter(lengthPredicate);

        // map - преобразует одни объекты в другие по определенному правилу

        Function<String, String> reverseFunction = word -> {
          char[] chars = word.toCharArray(); // на основе слова получаем массив символов
          for (int i = 0; i < chars.length / 2; i++) { // бежим до середины массива
              char temp = chars[i]; // заводим временную переменную и кладем в нее i-ый символ
              chars[i] = chars[chars.length - 1 - i]; // вместо i-го символа кладем туда противоположный
              chars[chars.length - 1 - i] = temp; // вместо противоположного кладем i-ый
          }
          return new String(chars); // создаем строку на основе развернутого массива
        }; // на вход передаем слово Hello, а на выход - olleH

        Stream<String> reversedWords = filteredWords.map(reverseFunction);

        // forEach - применяет для каждого объекта какую-то операцию (терминальный оператор, закрывает Stream)

        Consumer<String> redPrintConsumer = reversedWord -> {
            System.err.println(reversedWord);
        };

        reversedWords.forEach(redPrintConsumer);
    }
}
