package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Step;
import java.util.ArrayList;
import java.util.Random;

public class GCD {
    static Random random = new Random();
    public static String rules = "Find the greatest common divisor of given numbers.";

    public static void run() {
        Engine.run(getSteps(), rules, "GCD");
    }

    private static ArrayList<Step> getSteps() {
        ArrayList<Step> steps = new ArrayList<>();
        for (var step = 0; step < Engine.steps; step++) {
            int randomFirstNum = random.nextInt(100) + 1;
            int randomSecondNum = random.nextInt(100) + 1;
            String answer = getResult(randomFirstNum, randomSecondNum).toString();
            String question = String.format("Question: %s %s\n", randomFirstNum, randomSecondNum);
            steps.add(new Step(question, answer));
        }
        return steps;
    }

    private static Integer getResult(Integer firstNum, Integer secondNum) {
        int largestNumber = firstNum > secondNum ? firstNum : secondNum;
        int smallestNumber = firstNum < secondNum ? firstNum : secondNum;
        for (int currentNum = smallestNumber; currentNum > 0; currentNum--) {
            if (smallestNumber % currentNum == 0 && largestNumber % currentNum == 0) {
                return currentNum;
            }
        }
        return 1;
    }

}
