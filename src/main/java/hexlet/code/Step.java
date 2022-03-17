package hexlet.code;

public class Step {
    private String question;
    private String answer;

    public Step(String gameQuestion, String correctAnswer) {
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
