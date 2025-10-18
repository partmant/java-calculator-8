package calculator;

import calculator.io.InputView;
import calculator.io.OutputView;

public class Application {
    public static void main(String[] args) {
        String input = InputView.readInput();
        StringCalculator calculator = new StringCalculator();
        int result = calculator.calculate(input);
        OutputView.printResult(result);
    }
}