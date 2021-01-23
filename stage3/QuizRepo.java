package engine;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import java.util.stream.*;

@Component
public class QuizRepo {

    List<Quiz> quizzes = new ArrayList<Quiz>();

    public QuizRepo() {

    }
    public Quiz addQuiz(Quiz quiz) {
        Quiz newQuiz = new Quiz(quiz.getTitle(), quiz.getText(), quiz.getOptions(), quiz.getAnswer());
        quizzes.add(newQuiz);
        return newQuiz;
    }

    public Quiz getQuiz(int id) {
        Quiz quizFound = null;
        for ( Quiz quiz : quizzes) {
            if ( quiz.getId() == id ) {
                quizFound = quiz;
            }
        }
        return quizFound;
    }

    public List<Quiz> getAllQuizzes() {
        return quizzes;
    }

    public Message solve(int quizid, UserChoice userChoice) {
        Quiz quiz = getQuiz(quizid);
        if ( quiz == null) return null;

        // check if the answer is correct
        int[] userAnswers = userChoice.getAnswer();
        int[] correctAnswers = quiz.getAnswer();

        Set<Integer> uAnswers = new HashSet<>();
        Set<Integer> cAnswers = new HashSet<>();

        for ( int i : userAnswers) uAnswers.add(i);
        for (int i : correctAnswers) cAnswers.add(i);

        if ( cAnswers.equals(uAnswers) || cAnswers.contains(uAnswers) ){
            return new Message(true, "Congratulations, you're right!");
        }

        return new Message(false, "Wrong answer! Please, try again.");
    }


}
