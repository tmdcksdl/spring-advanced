package org.example.expert.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

;import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class PasswordEncoderTest {

    @InjectMocks
    private PasswordEncoder passwordEncoder;

    @Test
    void 비밀번호_검사_성공() {
        // given
        String rawPassword = "testPassword";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // when
        // matches 메서드의 매개변수 순서는 (원본 비밀번호, 인코딩된 비밀번호)이다.
        // 따라서 매개변수의 순서가 바뀌어야 한다.
        boolean actualResult = passwordEncoder.matches(rawPassword, encodedPassword);

        // then
        // 방법 1. isEqualTo 메서드를 통해 값 비교하기
        boolean expectedResult = true;
        assertThat(actualResult).isEqualTo(expectedResult);

        // 방법 2. assertTrue 메서드를 통해 true인지 확인하기
        // assertTrue(actualResult);

    }
}
