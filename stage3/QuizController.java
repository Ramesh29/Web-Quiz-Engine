package engine;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class QuizController {
    @Autowired
    QuizRepo quizRepo;

    @PostMapping("quizzes")
    public Quiz addQuiz(@Valid @RequestBody Quiz quiz) {
        Quiz newQuiz = quizRepo.addQuiz(quiz);
        return newQuiz;
    }

    @GetMapping("quizzes/{id}")
    public Quiz getQuiz(@PathVariable("id") int id) {
        Quiz quiz = quizRepo.getQuiz(id);
        if ( quiz == null ) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }

        return quiz;
    }
    @GetMapping("quizzes")
    public List<Quiz> getAllQuizzes() {
        return quizRepo.getAllQuizzes();
    }

    @PostMapping("quizzes/{id}/solve")
    public Message solve(@RequestBody UserChoice userChoice, @PathVariable("id") int id) {

        Message message = quizRepo.solve(id, userChoice);

        if ( message == null ) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }

        return message;

    }
}
