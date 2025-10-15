package calculator;

public class NumberExtractor {
	public static int[] parse(String[] parsedStrings) {
		if(parsedStrings == null || parsedStrings.length == 0) {
			return new int[0];
		}
		
		int[] numbers = new int[parsedStrings.length];
		
		for (int i = 0; i < parsedStrings.length; i++) {
			String parsedString = parsedStrings[i];
			
			if (parsedString == null || parsedString.isEmpty()) {
				throw new IllegalArgumentException("빈 값은 허용되지 않습니다."); 
			}
			
			if (!parsedString.matches("-?\\d+")) {
				throw new IllegalArgumentException("정수가 아닌 값이 포함되어 있습니다.");
			}
			
			int number = Integer.parseInt(parsedString);
			
			if (number <= 0) {
				throw new IllegalArgumentException("모든 숫자는 양수여야 합니다.");
			}
			
			numbers[i] = number;
		}
		
		return numbers;
	}
}
