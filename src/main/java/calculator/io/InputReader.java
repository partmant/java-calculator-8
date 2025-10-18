package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    public String readLine() {
        String line = Console.readLine();
        if (line == null) {
            throw new IllegalArgumentException("입력이 null입니다.");
        }
        return normalizeNewLine(line);
    }

    private String normalizeNewLine(String line) {
        return line.contains("\\n") ? line.replace("\\n", "\n") : line;
    }
}
