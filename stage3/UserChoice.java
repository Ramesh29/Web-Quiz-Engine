package engine;

import javax.validation.constraints.NotNull;

public class UserChoice {

    @NotNull(message="answer can not be null")
    private int[] answer;

    public UserChoice() {
    }

    public UserChoice(int[] answer) {
        this.answer = answer;
    }

    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
}
