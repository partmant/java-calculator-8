package calculator;

import calculator.io.InputView;
import calculator.io.OutputView;

public class StringCalculator {
    public static void main(String[] args) {
    	String input = InputView.readInput();
        String[] tokens = StringSplitter.split(input);
        int[] numbers = NumberExtractor.parse(tokens);
        int result = SumCalculator.calculateSum(numbers);

        OutputView.printResult(result);
    }
}