package calculator;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] splitTokens = StringSplitter.split(input);
        int[] numbers = NumberExtractor.parse(splitTokens);

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
