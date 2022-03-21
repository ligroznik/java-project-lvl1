package hexlet.code;

import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;

    public static void run(ArrayList<RoundData> rounds, String rules) {
        String userName = Cli.welcome();
        System.out.println(rules);
        for (var round : rounds) {
            System.out.println(round.getQuestion());
            System.out.print("Your answer: ");
            Scanner input = new Scanner(System.in);
            String userAnswer = input.nextLine();
            if (userAnswer.equals(round.getAnswer())) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", userAnswer, round.getAnswer());
                System.out.printf("Let's try again, %s!", userName);
                return;
            }
        }
        System.out.printf("Congratulations, %s!", userName);
    }
}
