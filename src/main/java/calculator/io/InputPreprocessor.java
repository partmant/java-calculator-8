package calculator.io;

public class InputPreprocessor {

    public String process(String firstLine, String secondLine) {
        if (firstLine.startsWith("//")) {
            if (secondLine == null) {
                throw new IllegalArgumentException("입력이 null입니다.");
            }
            return firstLine + "\n" + secondLine;
        }
        return firstLine;
    }
}