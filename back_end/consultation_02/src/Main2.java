/**
 * 7/24/2023
 * cohort23
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main2 {
    public static void main(String[] args) {

        int[] array = {4, 10, 45, 11, 14, 15, 32, 33, 11, 432};

        NumbersToStringProcessor processor = new NumbersToStringProcessor();
        processor.process(array, (a, b, c) -> "Три числа - " + a + ", " + b + ", " + c);
        processor.process(array, (a, b, c) -> "Сумма трех чисел: " + (a + b + c));
    }
}
