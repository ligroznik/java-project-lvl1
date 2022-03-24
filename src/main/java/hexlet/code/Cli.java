package hexlet.code;

public class Cli {
    public static void userGreeting() {
        System.out.println("\nWelcome to the Brain Games!");
        String name = Engine.requestName();
        System.out.println("Hello, " + name + "!");
    }
}
