package com.example.quizapp.user;

import com.example.quizapp.profile.Profile;
import com.example.quizapp.quiz.Quiz;
import com.example.quizapp.rating.Rate;
import com.example.quizapp.userResult.UserResult;
import com.example.quizapp.user_answer.UserAnswer;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "app_user") // Change the table name to avoid conflict
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    private String username;

    private String password;

    @OneToOne(mappedBy = "user")
    private Profile profile;


    @OneToMany(mappedBy = "user")
    private List<Quiz> quizzes;


    @OneToMany(mappedBy = "user")
    private List<Rate> rates;

    @OneToMany(mappedBy = "user")
    private List<UserAnswer> userAnswers;

    @OneToMany(mappedBy = "user")
    private List<UserResult> userResults;


    public User() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
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
