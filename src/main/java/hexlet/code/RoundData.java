package hexlet.code;

public final class RoundData {
    private final String question;
    private final String answer;

    public RoundData(String gameQuestion, String correctAnswer) {
        question = gameQuestion;
        answer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
