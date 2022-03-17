package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Step;
import java.util.ArrayList;
import java.util.Random;

public class Even {
    static Random random = new Random();
    public static String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run() {
        Engine.run(getSteps(), rules, "Even");
    }

    private static ArrayList<Step> getSteps() {
        ArrayList<Step> steps = new ArrayList<>();
        for (var step = 0; step < Engine.steps; step++) {
            int randomInt = random.nextInt(100) + 1;
            String answer = randomInt % 2 == 0 ? "yes" : "no";
            String question = "Question: " + randomInt;
            steps.add(new Step(question, answer));
        }
        return steps;
    }
}
