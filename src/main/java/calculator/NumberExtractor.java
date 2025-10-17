package calculator;

public class NumberExtractor {
	private static final String EMPTY_VALUE_ERROR = "빈 값은 허용되지 않습니다.";
	private static final String NON_INTEGER_ERROR = "정수가 아닌 값이 포함되어 있습니다.";
	private static final String NON_POSITIVE_ERROR = "모든 숫자는 양수여야 합니다.";
	
	public static int[] parse(String[] parsedStrings) {
		if(isNullOrEmpty(parsedStrings)) {
			return new int[0];
		}
		
		int[] numbers = new int[parsedStrings.length];
		for (int i = 0; i < parsedStrings.length; i++) {
			String token = parsedStrings[i];
			numbers[i] = convertToPositiveInteger(token);
		}
		return numbers;
	}
	
	private static boolean isNullOrEmpty(String[] array) {
		return array == null || array.length == 0;
	}
	
	private static int convertToPositiveInteger(String token) {
		validateNotEmpty(token);
		validateIntegerFormat(token);
		
		int number = Integer.parseInt(token);
		validatePositive(number);
		return number;
	}
	
	private static void validateNotEmpty(String token) {
		if (token == null || token.isEmpty()) {
			throw new IllegalArgumentException(EMPTY_VALUE_ERROR);
		}
	}
	
	private static void validateIntegerFormat(String token) {
		if (!token.matches("-?\\d+")) {
			throw new IllegalArgumentException(NON_INTEGER_ERROR);
		}
	}
	
	private static void validatePositive(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException(NON_POSITIVE_ERROR);
		}
	}
}
