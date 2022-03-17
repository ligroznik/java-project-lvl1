package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Step;
import java.util.ArrayList;
import java.util.Random;

public class Calc {
    static Random random = new Random();
    public static String rules = "What is the result of the expression?";

    public static void run() {
        Engine.run(getSteps(), rules, "Calc");
    }

    private static ArrayList<Step> getSteps() {
        ArrayList<Step> steps = new ArrayList<>();
        for (var step = 0; step < Engine.steps; step++) {
            int randomFirstNum;
            int randomSecondNum;
            Operations operation = getOperation(random.nextInt(90) + 1);
            if (operation.equals(Operations.MULTIPLICATION)) {
                randomFirstNum = random.nextInt(15) + 1;
                randomSecondNum = random.nextInt(15) + 1;
            } else {
                randomFirstNum = random.nextInt(100) + 1;
                randomSecondNum = random.nextInt(100) + 1;
            }
            String answer = getResult(randomFirstNum, randomSecondNum, operation).toString();
            String question = String.format("Question: %s %s %s\n", randomFirstNum, operation.getValue(), randomSecondNum);
            steps.add(new Step(question, answer));
        }
        return steps;
    }

    private static Operations getOperation(Integer randomNumber) {
        if (randomNumber > 0 && randomNumber <= 30) {
            return Operations.ADDITION;
        } else if (randomNumber > 30 && randomNumber <= 60) {
            return Operations.SUBTRACTION;
        }
        return Operations.MULTIPLICATION;
    }

    private static Integer getResult(Integer firstNum, Integer secondNum, Operations operation) {
        switch (operation) {
            case SUBTRACTION -> {
                return firstNum - secondNum;
            }
            case ADDITION -> {
                return firstNum + secondNum;
            }
            default -> {
                return firstNum * secondNum;
            }
        }
    }

    private enum Operations {
        ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*");

        private final String value;

        Operations(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
