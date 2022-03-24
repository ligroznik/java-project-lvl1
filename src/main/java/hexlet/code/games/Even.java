package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;
import hexlet.code.Utils;

public class Even {

    private static final int RANDOM_RANGE_LIMIT_1 = 1;
    private static final int RANDOM_RANGE_LIMIT_100 = 100;

    public static void run() {
        Engine.run(Even::generateNextRoundData, "Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private static RoundData generateNextRoundData() {
        int randomInt = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        String answer = randomInt % 2 == 0 ? "yes" : "no";
        return new RoundData(Integer.toString(randomInt), answer);
    }
}
