package hexlet.code;

import hexlet.code.games.Even;

public class App {

    public static void main(String[] args) {
        runGame(null);
    }

    public static void runGame(String name) {
        String[] menuItems = {"Greet", "Even"};
        Integer numberOfMenu = Cli.chooseGame(menuItems);
        switch (numberOfMenu) {
            case 1 -> Cli.welcome();
            case 2 -> {
                String currentName = name != null ? name : Cli.welcome(menuItems[numberOfMenu - 1]);
                Even.run(currentName);
                App.runGame(currentName);
            }
            default -> System.out.println("Goodbye!");
        }
    }
}
