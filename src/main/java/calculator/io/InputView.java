package calculator.io;

public class InputView {
    private static final InputReader reader = new InputReader();
    private static final InputPreprocessor preprocessor = new InputPreprocessor();

    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String firstLine = reader.readLine();
        String secondLine = "";

        if (firstLine.startsWith("//")) {
            secondLine = reader.readLine();
        }

        return preprocessor.process(firstLine, secondLine);
    }
}