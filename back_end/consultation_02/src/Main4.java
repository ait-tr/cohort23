import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 7/24/2023
 * cohort23
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main4 {
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>();
        wordsList.add("Hello");
        wordsList.add("Bye");
        wordsList.add("Marsel");
        wordsList.add("Java");
        wordsList.add("String");
        wordsList.add("SQL");

        List<String> processed = wordsList.stream()
                .filter(word -> word.length() > 3)
                .map(word -> {
                    char[] chars = word.toCharArray();
                    for (int i = 0; i < chars.length / 2; i++) {
                        char temp = chars[i];
                        chars[i] = chars[chars.length - 1 - i];
                        chars[chars.length - 1 - i] = temp;
                    }
                    return new String(chars);
                }).toList();
    }
}