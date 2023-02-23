package ladder.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BooleanGeneratorTest {
    @Test
    @DisplayName("랜덤 boolean 값은 true 혹은 false 이다.")
    void generateRandomBooleanTest() {
        BooleanGenerator generator = new RandomBooleanGenerator();

        assertThat(generator.generate())
            .isExactlyInstanceOf(Boolean.class);
    }
}
