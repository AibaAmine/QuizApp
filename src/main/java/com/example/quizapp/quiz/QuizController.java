package com.example.quizapp.quiz;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("createQuiz")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizService.createQuiz(quiz), HttpStatus.CREATED);
    }

    @PutMapping("updateQuiz/{id}")
    public ResponseEntity<?> updateQuiz(@PathVariable Integer id, @RequestBody Quiz quiz) {
        try {
            return new ResponseEntity<>(quizService.updateQuiz(id, quiz), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Quiz not found", HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("deleteQuiz/{id}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Integer id){
        try{
            quizService.deleteQuiz(id);
            return new ResponseEntity<>("Quiz deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Quiz not Founded",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("quizzes")
    public ResponseEntity<List<Quiz>> findAllQuizzes() {
        return new ResponseEntity<>(quizService.findAllQuizzes(), HttpStatus.OK);

    }

    @GetMapping("findQuizById/{id}")
    public ResponseEntity<?> findQuizById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(quizService.findQuizById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("quiz with the id : " + id + " not Founded", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("findQuizByTitle/{name}")
    public ResponseEntity<?> findQuizzesByTitle(@PathVariable String name) {
        try {
            return new ResponseEntity<>(quizService.findQuizzesByTitle(name), HttpStatus.FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("quizzes not founded", HttpStatus.NOT_FOUND);
        }
    }

}
