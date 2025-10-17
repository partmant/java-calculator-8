package calculator;

import java.util.regex.Pattern;

public class StringSplitter {
    private static final String DEFAULT_DELIMITERS_REGEX = "[,:]";
    private static final String INVALID_FORMAT_ERROR = "입력 형식이 잘못되었습니다.";
    private static final String NUMERIC_DELIMITER_ERROR = "숫자는 구분자로 사용할 수 없습니다.";
    private static final String CUSTOM_DEFAULT_MIXED_ERROR = "커스텀 구분자 사용 시 기본 구분자는 함께 사용할 수 없습니다.";

    public static String[] split(String input) {
        if (isNullOrEmpty(input)) {
            return new String[0];
        }

        if (isCustomDelimiterFormat(input)) {
            return splitWithCustomDelimiter(input);
        }

        return splitWithDefaultDelimiter(input);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean isCustomDelimiterFormat(String input) {
        return input.startsWith("//");
    }

    private static String[] splitWithCustomDelimiter(String input) {
        String[] parts = input.split("\n", 2);
        validateCustomDelimiterFormat(parts);

        String customDelimiter = parts[0].substring(2);
        String numberParts = parts[1];

        validateDelimiter(customDelimiter);
        validateNoDefaultDelimiter(numberParts);
        

        return numberParts.split(Pattern.quote(customDelimiter), -1);
    }

    private static String[] splitWithDefaultDelimiter(String input) {
    	return input.split(DEFAULT_DELIMITERS_REGEX, -1);
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private static boolean containsDefaultDelimiter(String input) {
        return Pattern.compile(DEFAULT_DELIMITERS_REGEX).matcher(input).find();
    }
    
    private static void validateCustomDelimiterFormat(String[] parts) {
    	if (parts.length < 2) {
    		throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
    	}
    }
    
    private static void validateDelimiter(String customDelimiter) {
    	if (isNumeric(customDelimiter)) {
    		throw new IllegalArgumentException(NUMERIC_DELIMITER_ERROR);
    	}
    }
    
    private static void validateNoDefaultDelimiter(String numbers) {
    	if (containsDefaultDelimiter(numbers)) {
            throw new IllegalArgumentException(CUSTOM_DEFAULT_MIXED_ERROR);
        }
    }
}
