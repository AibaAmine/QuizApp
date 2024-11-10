package com.example.quizapp.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {
    List<Quiz> findAllByTitleContaining(String title);
}
