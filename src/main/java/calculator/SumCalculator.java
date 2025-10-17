package calculator;

import java.util.Arrays;

public class SumCalculator {
    public static int add(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] separatedTokens = StringSplitter.split(input);
        int[] validatedNumbers = NumberExtractor.parse(separatedTokens);

        return calculateSum(validatedNumbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int calculateSum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}