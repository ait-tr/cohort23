/**
 * 7/24/2023
 * cohort23
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Main {
    public static void main(String[] args) {
        NumbersToStringFunction function1 = new NumbersToStringFunction() {
            @Override
            public String cast(int a, int b, int c) {
                return "Три числа - " + a + ", " + b + ", " + c;
            }
        };

        NumbersToStringFunction function2 = new NumbersToStringFunction() {
            @Override
            public String cast(int a, int b, int c) {
                return "Сумма трех чисел: " + (a + b + c);
            }
        };


        int[] a = {4, 10, 45, 11, 14, 15, 32, 33, 11, 432};

        NumbersToStringProcessor processor = new NumbersToStringProcessor();
        processor.process(a, function2);
    }
}
