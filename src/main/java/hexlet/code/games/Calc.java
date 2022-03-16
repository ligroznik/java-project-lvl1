package hexlet.code.games;

import interfaces.Game;
import java.util.Random;
import java.util.Scanner;

public class Calc implements Game {

    public static Boolean run(Integer steps) {
        try {
            for (int step = 1; step <= steps; step++) {
                Random r = new Random();
                int randomFirstNum;
                int randomSecondNum;
                Operations operation = getOperation(r.nextInt(90) + 1);
                if (operation.equals(Operations.MULTIPLICATION)) {
                    randomFirstNum = r.nextInt(15) + 1;
                    randomSecondNum = r.nextInt(15) + 1;
                } else {
                    randomFirstNum = r.nextInt(100) + 1;
                    randomSecondNum = r.nextInt(100) + 1;
                }
                Integer correctAnswer = getResult(randomFirstNum, randomSecondNum, operation);
                System.out.printf("Question: %s %s %s\n", randomFirstNum, operation.getValue(), randomSecondNum);
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

    private static Operations getOperation(Integer randomNumber) {
        if (randomNumber > 0 && randomNumber <= 30) {
            return Operations.ADDITION;
        } else if (randomNumber > 30 && randomNumber <= 60) {
            return Operations.SUBTRACTION;
        }
        return Operations.MULTIPLICATION;
    }

    private static Integer getResult(Integer firstNum, Integer secondNum, Operations operation) {
        switch (operation) {
            case SUBTRACTION -> {
                return firstNum - secondNum;
            }
            case ADDITION -> {
                return firstNum + secondNum;
            }
            default -> {
                return firstNum * secondNum;
            }
        }
    }

    private enum Operations {
        ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*");

        private final String value;

        Operations(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
