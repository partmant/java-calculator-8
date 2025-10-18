package calculator.io;

public class InputView {
    private static final InputReader reader = new InputReader();
    private static final InputPreprocessor preprocessor = new InputPreprocessor();

    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = reader.readLine();

        if (!input.startsWith("//")) {
            return input;
        }

        return processCustomDelimiterInput(input);
    }

    private static String processCustomDelimiterInput(String input) {
        if (input.contains("\n")) {
            String[] parts = input.split("\n", 2);
            return preprocessor.process(parts[0], parts[1]);
        }

        String secondLine = reader.readLine();
        return preprocessor.process(input, secondLine);
    }
}
