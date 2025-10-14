package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
	@Test
	void 기본_구분자_사용() {
		String input = "1,2:3";
		String[] result = StringSplitter.split(input);
		
		assertThat(result).containsExactly("1", "2", "3");
	}
	
    @Test
    void 커스텀_구분자_사용() {
    	String input = "//;\n1;2;3";
    	String[] result = StringSplitter.split(input);
    	
    	assertThat(result).containsExactly("1", "2", "3");
    }
    
    @Test
    void 커스텀_구분자가_숫자이면_예외_처리() {
    	String input = "//1\n,2,3";
    	
    	assertThatThrownBy(() -> StringSplitter.split(input))
    		.isInstanceOf(IllegalArgumentException.class)
    		.hasMessageContaining("숫자는 구분자로 사용할 수 없습니다.");
    }
    
    @Test
    void 구분자로_빈_값이_있으면_예외_처리() {
    	String input ="1,,2";
    	
    	assertThatThrownBy(() -> StringSplitter.split(input))
    		.isInstanceOf(IllegalArgumentException.class)
    		.hasMessageContaining("빈 값은 허용되지 않습니다.");
    }
    
    @Test
    void 커스텀_구분자와_기본_구분자를_혼용하면_예외_처리() {
    	String input = "//;\n1,2;3";
    	
    	assertThatThrownBy(() -> StringSplitter.split(input))
    		.isInstanceOf(IllegalArgumentException.class)
    		.hasMessageContaining("기본 구분자는 사용할 수 없습니다.");
    	
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
