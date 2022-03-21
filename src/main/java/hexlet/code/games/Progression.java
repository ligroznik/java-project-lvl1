package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;
import hexlet.code.Utils;

import java.util.ArrayList;

public class Progression {
    private static final int RANDOM_RANGE_LIMIT_0 = 0;
    private static final int RANDOM_RANGE_LIMIT_1 = 1;
    private static final int RANDOM_RANGE_LIMIT_5 = 5;
    private static final int RANDOM_RANGE_LIMIT_10 = 10;
    private static final int RANDOM_RANGE_LIMIT_50 = 50;

    public static void run() {
        Engine.run(getRoundsData(), "What number is missing in the progression?");
    }

    private static ArrayList<RoundData> getRoundsData() {
        ArrayList<RoundData> rounds = new ArrayList<>();
        for (var step = 0; step < Engine.ROUNDS; step++) {
            rounds.add(generateRoundData());
        }
        return rounds;
    }

    private static RoundData generateRoundData() {
        int progressionLength = Utils.getRandom(RANDOM_RANGE_LIMIT_5, RANDOM_RANGE_LIMIT_10);
        int d = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_10);
        int keyOfHiddenNum = Utils.getRandom(RANDOM_RANGE_LIMIT_0, progressionLength - 1);
        String[] arithmeticSequentially = getArithmeticSequentially(progressionLength, d);
        String answer = arithmeticSequentially[keyOfHiddenNum];
        String question = "Question: " + getQuestion(arithmeticSequentially, keyOfHiddenNum);
        return new RoundData(question, answer);
    }

    private static String[] getArithmeticSequentially(int progressionLength, int d) {
        String[] result = new String[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            int prevValue = i > 0
                    ? Integer.parseInt(result[i - 1])
                    : Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_50);
            result[i] = Integer.toString(prevValue + d);
        }
        return result;
    }

    private static String getQuestion(String[] arithmeticSequentially, int keyOfHiddenNum) {
        arithmeticSequentially[keyOfHiddenNum] = "..";
        return String.join(" ", arithmeticSequentially);
    }
}
