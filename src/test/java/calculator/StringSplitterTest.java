package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringSplitterTest {
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
    void 커스텀_구분자와_기본_구분자를_혼용하면_예외_처리() {
    	String input = "//;\n1,2;3";
    	
    	assertThatThrownBy(() -> StringSplitter.split(input))
    		.isInstanceOf(IllegalArgumentException.class)
    		.hasMessageContaining("커스텀 구분자 사용 시 기본 구분자는 함께 사용할 수 없습니다.");
    }
    
    @Test
    void 숫자_하나만_입력되면_그_숫자를_반환() {
    	String input = "3";
    	
    	String[] result = StringSplitter.split(input);
    	
    	assertThat(result).containsExactly("3");
    }
}
