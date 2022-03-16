package hexlet.code.games;

import interfaces.Game;
import java.util.Random;
import java.util.Scanner;

public class GCD implements Game {

    public static Boolean run(Integer steps) {
        try {
            for (int step = 1; step <= steps; step++) {
                Random r = new Random();
                int randomFirstNum = r.nextInt(100) + 1;
                int randomSecondNum = r.nextInt(100) + 1;

                Integer correctAnswer = getResult(randomFirstNum, randomSecondNum);
                System.out.printf("Question: %s %s\n", randomFirstNum, randomSecondNum);
                System.out.print("Your answer: ");
                Scanner input = new Scanner(System.in);
                String answer = input.nextLine();
                if (Integer.parseInt(answer) == correctAnswer) {
                    System.out.println("Correct!");
                } else {
                    System.out.printf("'%s' is wrong answer \uD83E\uDD72. Correct answer was '%s'%n", answer, correctAnswer);
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException ex) {
            System.out.print("Incorrect answer \uD83E\uDD72, use only numbers pls.");
            System.out.println();
            return false;
        }
    }


    private static Integer getResult(Integer firstNum, Integer secondNum) {
        int largestNumber = firstNum > secondNum ? firstNum : secondNum;
        int smallestNumber = firstNum < secondNum ? firstNum : secondNum;
        for (int currentNum = smallestNumber; currentNum > 0; currentNum--) {
            if (smallestNumber % currentNum == 0 && largestNumber % currentNum == 0) {
                return currentNum;
            }
        }
        return 1;
    }

}
