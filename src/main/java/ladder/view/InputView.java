package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ladder.error.ErrorMessage;

public class InputView {
    private static final String NUMERIC_FORMAT = "^-?[0-9]*$";
    private static final String DELIMITER = ",";

    private final Scanner sc = new Scanner(System.in);

    public List<String> requestNames() {
        printMessage(Message.ASK_USER_NAMES);

        List<String> names = Arrays.asList(sc.nextLine().split(DELIMITER));
        validateNoDuplication(names);

        return names;
    }

    public List<String> requestResults() {
        printMessage(Message.ASK_RESULTS);

        List<String> results = Arrays.asList(sc.nextLine().split(DELIMITER));
        validateAllResultsAreNotSame(results);

        return results;
    }

    private void validateAllResultsAreNotSame(List<String> results) {
        if (results.stream().distinct().count() == 1) {
            throw new IllegalArgumentException(ErrorMessage.ALL_SAME_RESULTS.getMessage());
        }
    }

    public int requestLadderHeight() {
        printMessage(Message.ASK_LADDER_HEIGHT);

        String input = sc.nextLine();
        validateIsNumeric(input);

        return Integer.parseInt(input);
    }

    private void validateNoDuplication(List<String> names) {
        if (hasDuplicateName(names)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION.getMessage());
        }
    }

    private boolean hasDuplicateName(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    private void validateIsNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getMessage());
        }
    }

    private boolean isNumeric(String input) {
        return input.matches(NUMERIC_FORMAT);
    }

    private void printMessage(Message message) {
        System.out.println(message.value);
    }

    private enum Message {
        ASK_USER_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
        ASK_LADDER_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
        ASK_RESULTS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        private final String value;

        Message(String value) {
            this.value = value;
        }
    }
}
