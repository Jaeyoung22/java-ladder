package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatchResultsTest {

    private MatchResults matchResults;

    @BeforeEach
    void setUp() {
        Name name1 = new Name("a");
        Name name2 = new Name("b");
        Result result1 = new Result("1");
        Result result2 = new Result("2");

        LinkedHashMap<Name, Result> map = new LinkedHashMap<>();
        map.put(name1, result1);
        map.put(name2, result2);
        matchResults = new MatchResults(map);
    }

    @ParameterizedTest(name = "사다리 실행 결과를 검색한다.")
    @CsvSource(value = {"a,1", "b,2"})
    void matchingSuccessTest(String str1, String str2) {
        assertThat(matchResults.findMatchResult(str1)).isEqualTo(str2);

    }

    @Test
    @DisplayName("참여자의 이름이 아닌 이름으로 검색할 때 예외 처리한다.")
    void matchingFailTest() {
        assertThatThrownBy(() -> matchResults.findMatchResult("1"));
    }

    @Test
    @DisplayName("이름을 전부 검색했는지 여부를 반환한다. - 전부 검색한 경우(all 입력)")
    void isAllCheckedTrueAllTest() {
        matchResults.findMatchResult("all");
        assertTrue(matchResults.isAllChecked());
    }

    @Test
    @DisplayName("이름을 전부 검색했는지 여부를 반환한다. - 전부 검색한 경우(각 원소를 각자 입력)")
    void isAllCheckedTrueEachTest() {
        matchResults.findMatchResult("a");
        matchResults.findMatchResult("b");
        assertTrue(matchResults.isAllChecked());
    }

    @Test
    @DisplayName("이름을 전부 검색했는지 여부를 반환한다. - 전부 검색하지 않은 경우")
    void isAllCheckedFalseTest() {
        matchResults.findMatchResult("a");
        assertFalse(matchResults.isAllChecked());
    }
}