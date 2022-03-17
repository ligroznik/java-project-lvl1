package hexlet.code;


import hexlet.code.games.*;
import java.util.Scanner;

public class App {
    private static final String[] menu = {
            "Greet",
            "Even",
            "Calc",
            "GCD",
            "Progression",
            "Prime"
    };

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + " - " + menu[i]);
        }
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        Scanner input = new Scanner(System.in);
        int numberOfMenu = input.nextInt();
        switch (menu[numberOfMenu - 1]) {
            case "Greet" -> Cli.welcome();
            case "Calc" -> Calc.run();
            case "Even" -> Even.run();
            case "GCD" -> GCD.run();
            case "Progression" -> Progression.run();
            case "Prime" -> Prime.run();
            default -> System.out.println("Goodbye!");
        }
    }
}
