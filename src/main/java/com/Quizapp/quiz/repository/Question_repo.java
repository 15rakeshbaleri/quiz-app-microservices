package com.Quizapp.quiz.repository;

import com.Quizapp.quiz.model.Question_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Question_repo extends JpaRepository<Question_model, Integer> {

    List<Question_model> findByCategory(String category);
    @Query(value = "SELECT * FROM question_model Q WHERE Q.category=:category ORDER BY RAND() LIMIT :numq", nativeQuery = true)
    List<Question_model> findRandomQuestionsbycategory(String category, int numq);
}
