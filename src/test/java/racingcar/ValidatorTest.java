package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidatorTest {
//    @ParameterizedTest
//    @ValueSource(strings = {"pobi", "summer, crong", "pobi, pobi", ""})
//    @DisplayName("이름에 대한 예외 처리")
//    void() {
//    }

    @Test
    @DisplayName("입력한 이름값이 한개인 경우")
    void oneNameTest() {
        String names = "pobi";
        Assertions.assertThatThrownBy(() -> {
                    Validator.validateNames(names);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름을 2개 이상 입력해주세요.");
    }

    @Test
    @DisplayName("이름이 5자 초과일 경우")
    void nameLengthTest() {
        String names = "summer,crong";
        Assertions.assertThatThrownBy(() -> {
                    Validator.validateNames(names);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 이름을 5자 이하로 등록해주세요");
    }

    @Test
    @DisplayName("중복된 이름이 있을 경우")
    void nameDuplicationTest() {
        String names = "pobi,pobi";
        Assertions.assertThatThrownBy(() -> {
                    Validator.validateNames(names);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복된 이름이 있습니다.");
    }

    @Test
    @DisplayName("빈 이름이 주어지거나 입력값이 없을 경우")
    void emptyNameTest() {
        String names = "";
        Assertions.assertThatThrownBy(() -> {
                    Validator.validateNames(names);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 빈 이름이 있습니다.");
    }

}
