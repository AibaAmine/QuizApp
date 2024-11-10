package com.example.quizapp.rating;

import com.example.quizapp.quiz.Quiz;
import com.example.quizapp.user.User;
import jakarta.persistence.*;

@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rate_id;

    private Long rating;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Rate() {
    }

    public Integer getRate_id() {
        return rate_id;
    }

    public void setRate_id(Integer rate_id) {
        this.rate_id = rate_id;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
