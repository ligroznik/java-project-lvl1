package hexlet.code.games;

import java.util.Arrays;

public class Games {
    public static void runGame(GameNames gameName, String name) {
        switch (gameName) {
            case Calc -> Calc.run(name);
            case Even -> Even.run(name);
        }
    }

    public static String[] getGamesArray() {
        return Arrays.stream(GameNames.values()).map(Enum::name).toArray(String[]::new);
    }
}
