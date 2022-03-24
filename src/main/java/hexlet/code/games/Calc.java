package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;
import hexlet.code.Utils;
import java.util.function.IntBinaryOperator;

public class Calc {
    private static final int RANDOM_RANGE_LIMIT_1 = 1;
    private static final int RANDOM_RANGE_LIMIT_100 = 100;

    public static void run() {
        Engine.run(Calc::generateNextRoundData, "What is the result of the expression?");
    }

    private static RoundData generateNextRoundData() {
        Operations operation = Operations.values()[Utils.getRandom(0, Operations.values().length)];
        int randomFirstNum = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        int randomSecondNum = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        String answer = Integer.toString(operation.binaryOperator.applyAsInt(randomFirstNum, randomSecondNum));
        String question = String.format("%d %s %d", randomFirstNum, operation, randomSecondNum);
        return new RoundData(question, answer);
    }

    private enum Operations {
        ADDITION("+", (a, b) -> a + b),
        SUBTRACTION("-", (a, b) -> a - b),
        MULTIPLICATION("*", (a, b) -> a * b);

        private final String operation;
        private final IntBinaryOperator binaryOperator;

        Operations(String operationValue, IntBinaryOperator binaryOperatorValue) {
            this.operation = operationValue;
            this.binaryOperator = binaryOperatorValue;
        }

        @Override
        public String toString() {
            return operation;
        }
    }
}
