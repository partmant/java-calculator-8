package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SumCalculatorTest {
	@Test
	void 빈_문자열은_0을_반환() {
		int result = SumCalculator.add("");
		assertThat(result).isEqualTo(0);
	}
	
	@Test
	void 기본_구분자_합계() {
		int result = SumCalculator.add("1,2:3");
		assertThat(result).isEqualTo(6);
	}
	
	@Test
	void 커스텀_구분자_합계() {
		int result = SumCalculator.add("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}
	
	@Test
	void 음수나_0_포함시_예외() {
        assertThatThrownBy(() -> SumCalculator.add("1,-2,3,0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("모든 숫자는 양수여야 합니다.");
    }
	
	@Test
	void 정수가_아닌_값_예외() {
        assertThatThrownBy(() -> SumCalculator.add("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수가 아닌 값이 포함되어 있습니다.");
    }
	
	@Test
	void 커스텀_구분자와_기본_구분자를_혼용하면_예외_처리() {
        assertThatThrownBy(() -> SumCalculator.add("//;\n1;2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자 사용 시 기본 구분자는 함께 사용할 수 없습니다.");
    }
}
