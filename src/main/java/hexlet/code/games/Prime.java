package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RoundData;
import hexlet.code.Utils;
import java.math.BigInteger;

public class Prime {

    private static final int RANDOM_RANGE_LIMIT_1 = 1;
    private static final int RANDOM_RANGE_LIMIT_100 = 100;

    public static void run() {
        Engine.run(Prime::generateNextRoundData, "Answer 'yes' if the number is prime, otherwise answer 'no'.");
    }

    private static RoundData generateNextRoundData() {
        int randomInt = Utils.getRandom(RANDOM_RANGE_LIMIT_1, RANDOM_RANGE_LIMIT_100);
        String answer = numberIsPrime(randomInt) ? "yes" : "no";
        return new RoundData(Integer.toString(randomInt), answer);
    }

    private static boolean numberIsPrime(int number) {
        BigInteger bigInteger = BigInteger.valueOf(number);
        return bigInteger.isProbablePrime((int) Math.log(number));
    }
}
