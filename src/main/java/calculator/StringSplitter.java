package calculator;

import java.util.regex.Pattern;

public class StringSplitter {
	private static final String DEFAULT_DELIMETERS = "[,:]";
	
	public static String[] split(String input) {
		if(input == null || input.isEmpty()) {
			return new String[0];
		}
		
		if(input.startsWith("//")) {
			String[] parts = input.split("\n", 2);
			if(parts.length < 2) {
				throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
			}
			
			String customDelimiter = parts[0].substring(2);
			
			if(customDelimiter.matches("\\d+")) {
				throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
			}
			
			if(containsDefaultDelimiter(parts[1])) {
				throw new IllegalArgumentException("기본 구분자는 사용할 수 없습니다.");
			}
			
			String[] tokens = parts[1].split(Pattern.quote(customDelimiter));
			validateNoEmptyValues(tokens);
			
			return tokens;
		}
		
		String[] tokens = input.split(DEFAULT_DELIMETERS);
		validateNoEmptyValues(tokens);
		
		return tokens;
	}
	
	private static boolean containsDefaultDelimiter(String input) {
		return input.contains(",") || input.contains(":");
	}
	
	private static void validateNoEmptyValues(String[] tokens) {
		for(String token : tokens) {
			if(token == null || token.isEmpty()) {
				throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
			}
		}
	}
}
