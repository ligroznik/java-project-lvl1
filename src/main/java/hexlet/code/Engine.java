package hexlet.code;

import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    public static final Integer steps = 3;

    public static String getUserAnswer(String question) {
        System.out.println(question);
        System.out.print("Your answer: ");
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void run(ArrayList<Step> steps, String rules, String gameName) {
        String userName = Engine.getUserName(gameName);
        Engine.showGameRules(rules);
        for (var step : steps) {
            if (!checkAnswer(getUserAnswer(step.getQuestion()), step.getAnswer())) {
                Engine.showGameOver(userName);
                return;
            }
        }
        Engine.showCongratulations(userName);
    }

    public static Boolean checkAnswer(String userAnswer, String answer) {
        if (userAnswer.equals(answer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.printf("'%s' is wrong answer \uD83E\uDD72. Correct answer was '%s'%n", userAnswer, answer);
            return false;
        }
    }

    public static void showGameRules(String rules) {
        System.out.println(rules);
    }

    public static String getUserName(String gameName) {
        return Cli.welcome(gameName);
    }

    public static void showCongratulations(String userName) {
        System.out.printf("Congratulations \uD83E\uDD73, %s!\n", userName);
    }

    public static void showGameOver(String userName) {
        System.out.printf("Let's try again, %s.\n", userName);
    }
}
