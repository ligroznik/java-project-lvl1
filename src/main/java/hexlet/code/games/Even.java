package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;
import hexlet.code.Utils;

import java.util.ArrayList;

public class Even {

    private static final int RANDOM_RANGE_LIMIT_1 = 1;
    private static final int RANDOM_RANGE_LIMIT_100 = 100;

    public static void run() {
        Engine.run(getRoundsData(), "Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private static ArrayList<RoundData> getRoundsData() {
        ArrayList<RoundData> rounds = new ArrayList<>();
        for (var step = 0; step < Engine.ROUNDS; step++) {
            rounds.add(generateRoundData());
        }
        return rounds;
    }

    private static RoundData generateRoundData() {
        int randomInt = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        String answer = randomInt % 2 == 0 ? "yes" : "no";
        String question = "Question: " + randomInt;
        return new RoundData(question, answer);
    }
}
