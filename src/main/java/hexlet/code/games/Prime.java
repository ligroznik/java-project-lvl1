package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Step;

import java.math.BigInteger;
import java.util.ArrayList;

public class Prime {

    public static void run() {
        Engine.run(getSteps(), "Answer 'yes' if the number is prime, otherwise answer 'no'.", "Prime");
    }

    private static ArrayList<Step> getSteps() {
        ArrayList<Step> steps = new ArrayList<>();
        for (var step = 0; step < Engine.STEPS; step++) {
            int randomInt = Engine.getRandom(Engine.RANGE_LIMIT_1, Engine.RANGE_LIMIT_100);
            String answer = numberIsPrime(randomInt) ? "yes" : "no";
            String question = "Question: " + randomInt;
            steps.add(new Step(question, answer));
        }
        return steps;
    }

    private static Boolean numberIsPrime(Integer number) {
        BigInteger bigInteger = BigInteger.valueOf(number);
        return bigInteger.isProbablePrime((int) Math.log(number));
    }
}
