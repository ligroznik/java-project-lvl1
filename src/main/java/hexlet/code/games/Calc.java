package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;
import hexlet.code.Utils;

import java.util.ArrayList;

public class Calc {
    public static void run() {
        Engine.run(getRoundsData(), "What is the result of the expression?");
    }

    private static final int RANDOM_RANGE_LIMIT_1 = 1;
    private static final int RANDOM_RANGE_LIMIT_100 = 100;
    private static final char[] OPERATION = {'*', '-', '+'};

    private static ArrayList<RoundData> getRoundsData() {
        ArrayList<RoundData> rounds = new ArrayList<>();
        for (var step = 0; step < Engine.ROUNDS; step++) {
            rounds.add(generateRoundData());
        }
        return rounds;
    }

    private static RoundData generateRoundData() {
        char operation = getOperation();
        int randomFirstNum = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        int randomSecondNum = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        String answer = generateCorrectAnswer(randomFirstNum, randomSecondNum, operation);
        String question = String.format("Question: %s %s %s\n", randomFirstNum, operation, randomSecondNum);
        return new RoundData(question, answer);
    }

    private static char getOperation() {
        return OPERATION[Utils.getRandom(0, OPERATION.length - 1)];
    }

    private static String generateCorrectAnswer(int firstNum, int secondNum, char operation) {
        switch (operation) {
            case '-' -> {
                return Integer.toString(firstNum - secondNum);
            }
            case '+' -> {
                return Integer.toString(firstNum + secondNum);
            }
            default -> {
                return Integer.toString(firstNum * secondNum);
            }
        }
    }
}
