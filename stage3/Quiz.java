package engine;



import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;

public class Quiz {

    private static int idgen = 0;
    private int id;
    @NotNull(message="title can not be null")
    @NotEmpty(message="title can not be empty")
    private String title;
    @NotNull(message="text can not be null")
    @NotEmpty(message="text can not be empty")
    private String text;
    @NotNull(message="options can not be null")
    @NotEmpty(message="options can not be empty")
    @Size(min=2, message="options should contain at least 2 items")
    private String[] options;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int[] answer;
    //private int answer;


    public Quiz() {}

    public Quiz(String title, String text, String[] options, int[] answers) {
        idgen++;
        this.id = idgen;
        this.title = title;
        this.text = text;
        this.options = options;

        this.answer = answers;
        if ( answers == null) {
            this.answer = new int[]{};
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }


    public int[] getAnswer() {
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + Arrays.toString(options) +
                ", answers=" + Arrays.toString(answer) +
                '}';
    }
}
