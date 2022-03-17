package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Step;
import java.util.ArrayList;

public class Progression {
    public static void run() {
        Engine.run(getSteps(), "What number is missing in the progression?", "Progression");
    }

    private static ArrayList<Step> getSteps() {
        ArrayList<Step> steps = new ArrayList<>();
        for (var step = 0; step < Engine.STEPS; step++) {
            int progressionLength = Engine.getRandom(Engine.RANGE_LIMIT_5, Engine.RANGE_LIMIT_10);
            int d = Engine.getRandom(Engine.RANGE_LIMIT_1, Engine.RANGE_LIMIT_10);
            int keyOfHiddenNum = Engine.getRandom(Engine.RANGE_LIMIT_0, progressionLength - 1);
            String[] arithmeticSequentially = getArithmeticSequentially(progressionLength, d);
            String answer = arithmeticSequentially[keyOfHiddenNum];
            String question = "Question: " + getQuestion(arithmeticSequentially, keyOfHiddenNum);
            steps.add(new Step(question, answer));
        }
        return steps;
    }

    private static String[] getArithmeticSequentially(Integer progressionLength, Integer d) {
        String[] result = new String[progressionLength];
        for (int indx = 0; indx < progressionLength; indx++) {
            int prevValue = indx > 0
                    ? Integer.parseInt(result[indx - 1])
                    : Engine.getRandom(Engine.RANGE_LIMIT_1, Engine.RANGE_LIMIT_50);
            result[indx] = Integer.toString(prevValue + d);
        }
        return result;
    }

    private static String getQuestion(String[] arithmeticSequentially, Integer keyOfHiddenNum) {
        arithmeticSequentially[keyOfHiddenNum] = "..";
        return String.join(" ", arithmeticSequentially);
    }
}
