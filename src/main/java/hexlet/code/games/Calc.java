package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Step;
import java.util.ArrayList;

public class Calc {
    public static void run() {
        Engine.run(getSteps(), "What is the result of the expression?", "Calc");
    }

    private static final String[] OPERATION = {"*", "-", "+"};

    private static ArrayList<Step> getSteps() {
        ArrayList<Step> steps = new ArrayList<>();
        for (var step = 0; step < Engine.STEPS; step++) {
            int randomFirstNum;
            int randomSecondNum;
            String operation = getOperation();
            if (operation.equals(OPERATION[0])) {
                randomFirstNum = Engine.getRandom(Engine.RANGE_LIMIT_1, Engine.RANGE_LIMIT_15);
                randomSecondNum = Engine.getRandom(Engine.RANGE_LIMIT_1, Engine.RANGE_LIMIT_15);
            } else {
                randomFirstNum = Engine.getRandom(Engine.RANGE_LIMIT_1, Engine.RANGE_LIMIT_100);
                randomSecondNum = Engine.getRandom(Engine.RANGE_LIMIT_1, Engine.RANGE_LIMIT_100);
            }
            String answer = getResult(randomFirstNum, randomSecondNum, operation);
            String question = String.format("Question: %s %s %s\n", randomFirstNum, operation, randomSecondNum);
            steps.add(new Step(question, answer));
        }
        return steps;
    }

    private static String getOperation() {
        return OPERATION[Engine.getRandom(0, OPERATION.length - 1)];
    }

    private static String getResult(Integer firstNum, Integer secondNum, String operation) {
        switch (operation) {
            case "-" -> {
                return Integer.toString(firstNum - secondNum);
            }
            case "+" -> {
                return Integer.toString(firstNum + secondNum);
            }
            default -> {
                return Integer.toString(firstNum * secondNum);
            }
        }
    }
}
