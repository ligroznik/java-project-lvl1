package hexlet.code.games;

import interfaces.Game;
import java.util.Random;
import java.util.Scanner;

public class Even implements Game {

    public static void run(String name) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        boolean answerIsTrue;
        int questions = 3;
        do {
            Random r = new Random();
            int randomInt = r.nextInt(100) + 1;
            System.out.println("Question: " + randomInt);
            System.out.print("Your answer: ");
            Scanner input = new Scanner(System.in);
            String answer = input.nextLine();
            if (answer.equals("yes") && randomInt % 2 == 0 || answer.equals("no") && randomInt % 2 != 0) {
                System.out.println("Correct!");
                answerIsTrue = true;
                --questions;
            } else {
                answerIsTrue = false;
                System.out.printf("'%s' is wrong answer \uD83E\uDD72. Correct answer was '%s'%n\n", answer, answer.equals("yes") ? "no" : "yes");
                break;
            }
        } while (questions > 0);
        if (answerIsTrue) {
            System.out.printf("Congratulations \uD83E\uDD73, %s!%n\n", name);
        }
    }
}
