package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;
import hexlet.code.Utils;

public class GCD {

    private static final int RANDOM_RANGE_LIMIT_1 = 1;
    private static final int RANDOM_RANGE_LIMIT_100 = 100;

    public static void run() {
        Engine.run(GCD::generateNextRoundData, "Find the greatest common divisor of given numbers.");
    }

    private static RoundData generateNextRoundData() {
        int randomFirstNum = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        int randomSecondNum = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        String answer = generateCorrectAnswer(randomFirstNum, randomSecondNum);
        String question = String.format("%s %s", randomFirstNum, randomSecondNum);
        return new RoundData(question, answer);
    }

    private static String generateCorrectAnswer(int firstNum, int secondNum) {
        int largestNumber = Math.max(firstNum, secondNum);
        int smallestNumber = Math.min(firstNum, secondNum);
        for (int currentNum = smallestNumber; currentNum > 0; currentNum--) {
            if (smallestNumber % currentNum == 0 && largestNumber % currentNum == 0) {
                return Integer.toString(currentNum);
            }
        }
        return "1";
    }

}
