package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;
import hexlet.code.Utils;

public class Progression {
    private static final int RANDOM_RANGE_LIMIT_0 = 0;
    private static final int RANDOM_RANGE_LIMIT_1 = 1;
    private static final int RANDOM_RANGE_LIMIT_5 = 5;
    private static final int RANDOM_RANGE_LIMIT_10 = 10;
    private static final int RANDOM_RANGE_LIMIT_50 = 50;

    public static void run() {
        Engine.run(Progression::generateNextRoundData, "What number is missing in the progression?");
    }

    private static RoundData generateNextRoundData() {
        int firstElement = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_50);
        int progressionLength = Utils.getRandom(RANDOM_RANGE_LIMIT_5, RANDOM_RANGE_LIMIT_10);
        int d = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_10);
        int keyOfHiddenNum = Utils.getRandom(RANDOM_RANGE_LIMIT_0, progressionLength);
        String[] arithmeticSequentially = getArithmeticSequentially(firstElement, progressionLength, d);
        String answer = arithmeticSequentially[keyOfHiddenNum];
        return new RoundData(getQuestion(arithmeticSequentially, keyOfHiddenNum), answer);
    }

    private static String[] getArithmeticSequentially(int firstElement, int progressionLength, int d) {
        String[] result = new String[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            result[i] = Integer.toString(i == 0 ? firstElement : firstElement + (i * d));
        }
        return result;
    }

    private static String getQuestion(String[] arithmeticSequentially, int keyOfHiddenNum) {
        arithmeticSequentially[keyOfHiddenNum] = "..";
        return String.join(" ", arithmeticSequentially);
    }
}
