package ladder.view;

import java.util.stream.Collectors;

import ladder.domain.Ladder;
import ladder.domain.LadderFormat;
import ladder.domain.Line;
import ladder.domain.Names;

public class ResultView {
    private static final String LEG = "|";
    private static final String BLANK = " ";

    public static void printResult(Names names, Ladder ladder) {
        printNames(names);
        printLadder(ladder);
    }

    private static void printNames(Names names) {
        String result = names.getNames().stream()
            .map(name -> String.format(NAME_FORMAT, name))
            .collect(Collectors.joining());
        System.out.println(result);
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder) {
            String result = BLANK.repeat(WIDTH);
            result += getShapeOf(line);
            result += LEG;
            System.out.println(result);
        }
    }

    private static String getShapeOf(Line line) {
        return line.getLine().stream()
            .map(LadderFormat::getComponent)
            .map(component -> LEG + component.repeat(WIDTH))
            .collect(Collectors.joining());
    }
}
