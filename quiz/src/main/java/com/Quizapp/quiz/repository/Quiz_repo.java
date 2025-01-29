package com.Quizapp.quiz.repository;

import com.Quizapp.quiz.model.Quiz_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Quiz_repo extends JpaRepository<Quiz_model, Integer> {
}
