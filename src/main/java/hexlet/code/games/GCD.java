package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;
import hexlet.code.Utils;

import java.util.ArrayList;

public class GCD {

    private static final int RANDOM_RANGE_LIMIT_1 = 1;
    private static final int RANDOM_RANGE_LIMIT_100 = 100;

    public static void run() {
        Engine.run(getRoundsData(), "Find the greatest common divisor of given numbers.");
    }

    private static ArrayList<RoundData> getRoundsData() {
        ArrayList<RoundData> rounds = new ArrayList<>();
        for (var step = 0; step < Engine.ROUNDS; step++) {
            rounds.add(generateRoundData());
        }
        return rounds;
    }

    private static RoundData generateRoundData() {
        int randomFirstNum = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        int randomSecondNum = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        String answer = generateCorrectAnswer(randomFirstNum, randomSecondNum);
        String question = String.format("Question: %s %s\n", randomFirstNum, randomSecondNum);
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
