package com.example.quizapp.quiz;

import com.example.quizapp.question.Question;
import com.example.quizapp.rating.Rate;
import com.example.quizapp.user.User;
import com.example.quizapp.userResult.UserResult;
import com.example.quizapp.user_answer.UserAnswer;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer quiz_id;

    private String title;

    //TODO   : add search by topic endpoint
    private String topic;

    private String difficulty;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "quiz")
    private List<Question> questions;


    @OneToMany(mappedBy = "quiz")
    private List<Rate> rates;

    @OneToMany(mappedBy = "quiz")
    private List<UserAnswer> userAnswers;

    @OneToMany(mappedBy = "quiz")
    private List<UserResult> userResults;


    public Quiz() {
    }

    public Integer getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Integer quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public List<UserResult> getUserResults() {
        return userResults;
    }

    public void setUserResults(List<UserResult> userResults) {
        this.userResults = userResults;
    }
}

