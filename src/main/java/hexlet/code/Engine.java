package hexlet.code;

import java.util.ArrayList;
import java.util.Scanner;

public class Engine {
    public static final Integer STEPS = 3;
    public static final int RANGE_LIMIT_0 = 0;
    public static final int RANGE_LIMIT_1 = 1;
    public static final int RANGE_LIMIT_5 = 5;
    public static final int RANGE_LIMIT_10 = 10;
    public static final int RANGE_LIMIT_15 = 15;
    public static final int RANGE_LIMIT_50 = 50;
    public static final int RANGE_LIMIT_100 = 100;


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
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", userAnswer, answer);
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
        System.out.printf("Congratulations, %s!\n", userName);
    }

    public static void showGameOver(String userName) {
        System.out.printf("Let's try again, %s!\n", userName);
    }

    public static int getRandom(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
