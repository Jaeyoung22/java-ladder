package ladder;

import ladder.controller.LadderController;
import ladder.util.RandomBooleanGenerator;

public class Application {
    // TODO: 2023/02/24 불변 컬렉션 반환할 수 있는 곳 찾아보기 Collection.unmodifiable()
    // TODO: 2023/02/25 결과 입력할 때 검증 순서 변경
    public static void main(String[] args) {
        new LadderController(new RandomBooleanGenerator()).execute();
    }
}
