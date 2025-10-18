package calculator;

import java.util.Arrays;

public class SumCalculator {
    public static int calculateSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}