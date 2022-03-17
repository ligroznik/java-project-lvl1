package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Step;
import java.util.ArrayList;

public class Even {
    public static void run() {
        Engine.run(getSteps(), "Answer 'yes' if the number is even, otherwise answer 'no'.", "Even");
    }

    private static ArrayList<Step> getSteps() {
        ArrayList<Step> steps = new ArrayList<>();
        for (var step = 0; step < Engine.STEPS; step++) {
            int randomInt = Engine.getRandom(Engine.RANGE_LIMIT_1, Engine.RANGE_LIMIT_100);
            String answer = randomInt % 2 == 0 ? "yes" : "no";
            String question = "Question: " + randomInt;
            steps.add(new Step(question, answer));
        }
        return steps;
    }
}
