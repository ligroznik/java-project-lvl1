package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Step;
import java.util.ArrayList;
import java.util.Random;

public class Prime {
    static Random random = new Random();
    public static String rules = "Answer 'yes' if the number is prime, otherwise answer 'no'.";

    public static void run() {
        Engine.run(getSteps(), rules, "Prime");
    }

    private static ArrayList<Step> getSteps() {
        ArrayList<Step> steps = new ArrayList<>();
        for (var step = 0; step < Engine.steps; step++) {
            int randomInt = random.nextInt(100) + 1;
            String answer = numberIsPrime(randomInt) ? "yes" : "no";
            String question = "Question: " + randomInt;
            steps.add(new Step(question, answer));
        }
        return steps;
    }

    private static Boolean numberIsPrime(Integer number) {
        return number != 1 && (number == 2 || number % 2 != 0);
    }
}
