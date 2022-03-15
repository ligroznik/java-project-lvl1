package hexlet.code;

import hexlet.code.games.GameNames;
import hexlet.code.games.Games;
import java.util.Arrays;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        runGame(null);
    }

    public static void runGame(String name) {
        String[] menuItems = Stream.concat(Arrays.stream(new String[]{"Greet"}), Arrays.stream(Games.getGamesArray()))
                .toArray(String[]::new);
        int numberOfMenu = Cli.chooseGame(menuItems);

        if (numberOfMenu == 1) {
            Cli.welcome();
        } else if (numberOfMenu > 1) {
            if (numberOfMenu <= menuItems.length) {
                String currentName = name != null ? name : Cli.welcome(menuItems[numberOfMenu - 1]);
                Games.runGame(GameNames.valueOf(menuItems[numberOfMenu - 1]), currentName);
                App.runGame(currentName);
            } else {
                System.out.print("There is no game with that number \uD83E\uDD72. Pls try again.\n");
                App.runGame(null);
            }
        } else {
            System.out.println("Goodbye!");
        }
    }
}
