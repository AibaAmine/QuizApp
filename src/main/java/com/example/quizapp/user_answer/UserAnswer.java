package com.example.quizapp.user_answer;

import com.example.quizapp.QuestionResponseOption.QuestionOption;
import com.example.quizapp.question.Question;
import com.example.quizapp.quiz.Quiz;
import com.example.quizapp.user.User;
import jakarta.persistence.*;
import org.springframework.context.annotation.EnableMBeanExport;

@Entity
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userAnswer_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;


    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "selected_option_id")
    private QuestionOption selectedOption;

    public UserAnswer() {
    }

    public Integer getUserAnswer_id() {
        return userAnswer_id;
    }

    public void setUserAnswer_id(Integer userAnswer_id) {
        this.userAnswer_id = userAnswer_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public QuestionOption getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(QuestionOption selectedOption) {
        this.selectedOption = selectedOption;
    }
}
