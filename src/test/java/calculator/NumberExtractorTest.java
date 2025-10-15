package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumberExtractorTest {
	@Test
	void 문자열_배열에서_숫자를_추출() {
		String[] input = {"1", "2", "3"};
		int[] result = NumberExtractor.parse(input);
		
		assertThat(result).containsExactly(1, 2, 3);
	}
	
	@Test
	void 숫자_하나만_있으면_그_값을_반환() {
		String[] input = {"5"};
		int[] result = NumberExtractor.parse(input);
		
		assertThat(result).containsExactly(5);
	}
	
	@Test
	void 빈_배열이면_빈_배열_반환() {
		String[] input = {};
		int[] result = NumberExtractor.parse(input);
		
		assertThat(result).isEmpty();
	}
	
	@Test
	void 정수가_아닌_값이_있으면_예외_처리() {
		String[] input = {"1", "a", "b"};
		
		assertThatThrownBy(() -> NumberExtractor.parse(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("정수가 아닌 값이 포함되어 있습니다.");
	}
	
	@Test
	void 음수나_0이_포함되면_예외_처리() {
		String[] input = {"1", "-2", "3", "0"};
		
		assertThatThrownBy(() -> NumberExtractor.parse(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("모든 숫자는 양수여야 합니다.");
	}
	
	@Test
	void 빈_값이_있으면_예외_처리() {
		String[] input = {"1", "", "3"};
		
		assertThatThrownBy(() -> NumberExtractor.parse(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("빈 값은 허용되지 않습니다.");
	}
}
