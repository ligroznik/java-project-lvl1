package hexlet.code;

public class Utils {
    public static int getRandom(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
