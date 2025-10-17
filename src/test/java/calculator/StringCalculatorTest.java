package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest extends NsTest {

    @Test
    void 기본_구분자_입력_결과_확인() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_입력_결과_확인() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    
    @Test
    void 숫자_하나만_입력시_그_값을_반환() {
        assertSimpleTest(() -> {
            run("3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 빈_입력값은_0을_반환() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 음수나_0_포함시_예외_발생() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,-2,3,0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("모든 숫자는 양수여야 합니다.")
        );
    }

    @Test
    void 커스텀_구분자와_기본_구분자_혼용시_예외_발생() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\n1;2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀 구분자 사용 시 기본 구분자는 함께 사용할 수 없습니다.")
        );
    }

    @Override
    public void runMain() {
        StringCalculator.main(new String[]{});
    }
}
