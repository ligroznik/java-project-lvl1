package hexlet.code.games;

import interfaces.Game;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Progression implements Game {
    static Random random = new Random();

    public static Boolean run(Integer steps) {
        try {
            for (int step = 1; step <= steps; step++) {
                int progressionLength = random.nextInt(5) + 5;
                int d = random.nextInt(10) + 1;
                int KeyOfHiddenNum = random.nextInt(progressionLength - 1);

                Integer[] arithmeticSequentially = getArithmeticSequentially(progressionLength, d);
                String question = getQuestion(arithmeticSequentially, KeyOfHiddenNum);
                System.out.printf("Question: %s\n", question);
                System.out.print("Your answer: ");
                Scanner input = new Scanner(System.in);
                String answer = input.nextLine();
                if (Integer.parseInt(answer) == arithmeticSequentially[KeyOfHiddenNum]) {
                    System.out.println("Correct!");
                } else {
                    System.out.printf("'%s' is wrong answer \uD83E\uDD72. Correct answer was '%s'%n", answer, arithmeticSequentially[KeyOfHiddenNum]);
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

    private static Integer[] getArithmeticSequentially(Integer progressionLength, Integer d) {
        Integer[] result = new Integer[progressionLength];
        for (int indx = 0; indx < progressionLength; indx++) {
            int prevValue = indx > 0 ? result[indx - 1] : random.nextInt(50) + 1;
            result[indx] = prevValue + d;
        }
        return result;
    }

    private static String getQuestion(Integer[] arithmeticSequentially, Integer KeyOfHiddenNum) {
        String startString = Stream.of(Arrays.copyOfRange(arithmeticSequentially, 0, KeyOfHiddenNum))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        String endString = Stream.of(Arrays.copyOfRange(arithmeticSequentially, KeyOfHiddenNum + 1, arithmeticSequentially.length))
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return startString + " .. " + endString;
    }
}
