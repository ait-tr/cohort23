/**
 * 7/24/2023
 * cohort23
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class NumbersToStringProcessor {
    public void process(int[] array, NumbersToStringFunction function) {
        for (int i = 0; i < array.length - 2; i++) {
            String s = function.cast(array[i], array[i + 1], array[i + 2]);
            System.out.println(s);
        }
    }
}
