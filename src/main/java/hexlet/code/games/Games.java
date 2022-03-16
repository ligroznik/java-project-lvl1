package hexlet.code.games;

import java.util.Arrays;

public class Games {
    public static void runGame(GameNames gameName, String name) {
        boolean gameIsComplete = false;
        switch (gameName) {
            case Calc -> gameIsComplete = Calc.run(3);
            case Even -> gameIsComplete = Even.run(3);
            case GCD -> gameIsComplete = GCD.run(3);
            case Progression -> gameIsComplete = Progression.run(3);
        }
        if (gameIsComplete) {
            System.out.printf("Congratulations \uD83E\uDD73, %s!\n", name);
            System.out.println();
        } else {
            System.out.printf("Let's try again, %s.\n", name);
            System.out.println();
        }
    }

    public static String[] getGamesArray() {
        return Arrays.stream(GameNames.values()).map(Enum::name).toArray(String[]::new);
    }
}
