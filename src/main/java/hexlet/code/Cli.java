package hexlet.code;

import java.util.Scanner;

public final class Cli {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void userGreeting() {
        System.out.println("\nWelcome to the Brain Games!");
        String name = requestName();
        System.out.println("Hello, " + name + "!");
    }

    private static String requestName() {
        System.out.print("May I have your name? ");
        return SCANNER.next();
    }
}
