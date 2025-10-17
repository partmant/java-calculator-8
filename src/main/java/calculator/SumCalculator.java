package calculator;

import java.util.Arrays;

public class SumCalculator {
    public static int calculateSum(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("입력값이 null일 수 없습니다.");
        }
        return Arrays.stream(numbers).sum();
    }
}