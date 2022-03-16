package hexlet.code.games;

import interfaces.Game;
import java.util.Random;
import java.util.Scanner;

public class Even implements Game {
    static Random random = new Random();

    public static Boolean run(Integer steps) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int step = 1; step <= steps; step++) {
            int randomInt = random.nextInt(100) + 1;
            System.out.println("Question: " + randomInt);
            System.out.print("Your answer: ");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if (answer.equals("yes") && randomInt % 2 == 0 || answer.equals("no") && randomInt % 2 != 0) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer \uD83E\uDD72. Correct answer was '%s'%n\n", answer, answer.equals("yes") ? "no" : "yes");
                System.out.println();
                return false;
            }
        }
        return true;
    }
}
