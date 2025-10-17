package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readInput() {
    	System.out.println("덧셈할 문자열을 입력해 주세요.");

        String firstLine = Console.readLine();

        if (firstLine != null && firstLine.startsWith("//")) {
            String secondLine = Console.readLine();
            if (secondLine == null) {
                secondLine = "";
            }
            return firstLine + "\n" + secondLine;
        }
        
        if (firstLine == null) {
        	return "";
        }
        return firstLine;
    }
}
