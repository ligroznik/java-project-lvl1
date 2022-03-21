package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String welcome() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println("Hello, " + name + "!");
        return name;
    }
}
