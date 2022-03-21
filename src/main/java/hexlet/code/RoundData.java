package hexlet.code;

public class RoundData {
    private final String question;
    private final String answer;

    public RoundData(String gameQuestion, String correctAnswer) {
        this.question = gameQuestion;
        this.answer = correctAnswer;
    }

    /**
     * getter question ...
     *
     * @return String value.
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * getter answer ...
     *
     * @return String value.
     */
    public String getAnswer() {
        return this.answer;
    }
}
