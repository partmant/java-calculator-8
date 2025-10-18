package calculator;

public class StringCalculator {

    public int calculate(String input) {
        String[] tokens = StringSplitter.split(input);
        int[] numbers = NumberExtractor.parse(tokens);
        return SumCalculator.calculateSum(numbers);
    }
}
