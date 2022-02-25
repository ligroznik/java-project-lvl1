package hexlet.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cli {
    public static void welcome() throws IOException {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println("Hello, " + name + "!");
    }
}
