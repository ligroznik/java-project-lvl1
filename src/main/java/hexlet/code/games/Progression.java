package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Step;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Progression {
    static Random random = new Random();
    public static String rules = "What number is missing in the progression?";

    public static void run() {
        Engine.run(getSteps(), rules, "Progression");
    }

    private static ArrayList<Step> getSteps() {
        ArrayList<Step> steps = new ArrayList<>();
        for (var step = 0; step < Engine.steps; step++) {
            int progressionLength = random.nextInt(5) + 5;
            int d = random.nextInt(10) + 1;
            int KeyOfHiddenNum = random.nextInt(progressionLength - 1);
            Integer[] arithmeticSequentially = getArithmeticSequentially(progressionLength, d);
            String answer = arithmeticSequentially[KeyOfHiddenNum].toString();
            String question = "Question: " + getQuestion(arithmeticSequentially, KeyOfHiddenNum);
            steps.add(new Step(question, answer));
        }
        return steps;
    }

    private static Integer[] getArithmeticSequentially(Integer progressionLength, Integer d) {
        Integer[] result = new Integer[progressionLength];
        for (int indx = 0; indx < progressionLength; indx++) {
            int prevValue = indx > 0 ? result[indx - 1] : random.nextInt(50) + 1;
            result[indx] = prevValue + d;
        }
        return result;
    }

    private static String getQuestion(Integer[] arithmeticSequentially, Integer KeyOfHiddenNum) {
        String startString = Stream.of(Arrays.copyOfRange(arithmeticSequentially, 0, KeyOfHiddenNum))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        String endString = Stream.of(Arrays.copyOfRange(arithmeticSequentially, KeyOfHiddenNum + 1, arithmeticSequentially.length))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return startString + " .. " + endString;
    }
}
