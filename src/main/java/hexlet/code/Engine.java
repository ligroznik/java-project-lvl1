package hexlet.code;

import java.util.Scanner;

public abstract class Engine implements GameInterface {
    private static final String WRONG_ANSWER_MESSAGE = "'%s' is wrong answer ;(. Correct answer was '%s'.\n"
            + "Let's try again, %s!";
    private static final String CORRECT_ANSWER_MESSAGE = "Correct!";
    private static final String CONGRATULATIONS_MESSAGE = "Congratulations, %s!";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int ROUNDS = 3;
    private final String name;
    private final String rules;

    public Engine(String inputName, String inputRules) {
        name = inputName;
        rules = inputRules;
    }

    @Override
    public final void run() {
        System.out.println("\nWelcome to the Brain Games!");
        String userName = requestName();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rules);
        for (var step = 0; step < ROUNDS; step++) {
            RoundData round = generateNextRoundData();
            System.out.println("Question: " + round.getQuestion());
            System.out.print("Your answer: ");
            String userAnswer = SCANNER.next();
            if (userAnswer.equals(round.getAnswer())) {
                System.out.println(CORRECT_ANSWER_MESSAGE);
            } else {
                System.out.printf(WRONG_ANSWER_MESSAGE, userAnswer, round.getAnswer(), userName);
                return;
            }
        }

        System.out.printf(CONGRATULATIONS_MESSAGE, userName);
    }

    @Override
    public final String getName() {
        return name;
    }

    private static String requestName() {
        System.out.print("May I have your name? ");
        return SCANNER.next();
    }

    protected abstract RoundData generateNextRoundData();
}
