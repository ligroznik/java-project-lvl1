package hexlet.code;

import hexlet.code.games.Progression;
import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = createMenu();
        menu.showMenu();
        int selectedMenuItem = getUserSelectedMenuItem(menu);
        menu.runSelectedMenuItemHandle(selectedMenuItem);
    }

    private static int getUserSelectedMenuItem(Menu menu) {
        int numberOfMenu;
        while (true) {
            System.out.print("Your choice: ");
            numberOfMenu = SCANNER.nextInt();
            if (!menu.hasMenuItem(numberOfMenu)) {
                System.out.println("You entered an invalid menu item number, please try again.");
            } else {
                break;
            }
        }
        return numberOfMenu;
    }

    private static Menu createMenu() {
        Menu menu = new Menu();
        menu.addMenuItem(1, "Greet", Cli::userGreeting);
        generateGameList().forEach(game -> menu.addMenuItem(menu.getMenuItemSize() + 1, game.getName(), game::run));
        menu.addMenuItem(0, "Exit", () -> System.out.println("Goodbye!"));
        return menu;
    }

    private static List<GameInterface> generateGameList() {
        List<GameInterface> gameList = new ArrayList<>();
        gameList.add(new Even());
        gameList.add(new Calc());
        gameList.add(new GCD());
        gameList.add(new Progression());
        gameList.add(new Prime());
        return gameList;
    }
}
