package com.example.quizapp.quiz;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepo quizRepo;

    public QuizService(QuizRepo quizRepo) {
        this.quizRepo = quizRepo;
    }


    public Quiz createQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    public Quiz updateQuiz(Integer id, Quiz quiz) {
        Quiz updatedQuiz = quizRepo.findById(id).orElse(null);
        if (updatedQuiz == null) {
            throw new IllegalArgumentException("quiz not found");
        }
        updatedQuiz.setDescription(quiz.getDescription());
        updatedQuiz.setQuestions(quiz.getQuestions());
        updatedQuiz.setTitle(quiz.getTitle());
        updatedQuiz.setUser(quiz.getUser());
        return quizRepo.save(updatedQuiz);
    }

    public void deleteQuiz(Integer id) {
        Quiz quiz = findQuizById(id);
        if (quiz != null) {
            quizRepo.deleteById(id);
        }
        else throw new IllegalArgumentException("Id not found");
    }

    public List<Quiz> findAllQuizzes() {
        return quizRepo.findAll();
    }

    public List<Quiz> findQuizzesByTitle(String title) {
        List<Quiz> quizzes = quizRepo.findAllByTitleContaining(title);
        if (quizzes.isEmpty()) {
            throw new IllegalArgumentException("quizzes with title " + title + " not founded");
        } else return quizzes;

    }

    public Quiz findQuizById(Integer id) {
        return quizRepo.findById(id).orElseThrow();
    }

}
