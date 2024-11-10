package com.example.quizapp.userResult;

import com.example.quizapp.quiz.Quiz;
import com.example.quizapp.user.User;
import jakarta.persistence.*;
import org.springframework.context.annotation.EnableMBeanExport;

@Entity
public class UserResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userResult_id;
    private Long score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public UserResult() {
    }

    public Integer getUserResult_id() {
        return userResult_id;
    }

    public void setUserResult_id(Integer userResult_id) {
        this.userResult_id = userResult_id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
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
}
