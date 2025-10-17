package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class SumCalculatorTest {
    @Test
    void 빈_배열은_0을_반환한다() {
        int result = SumCalculator.calculateSum(new int[0]);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_배열의_합을_계산한다() {
        int result = SumCalculator.calculateSum(new int[]{1, 2, 3});
        assertThat(result).isEqualTo(6);
    }
}
