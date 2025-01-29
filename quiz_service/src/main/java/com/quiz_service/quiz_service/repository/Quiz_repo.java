package com.quiz_service.quiz_service.repository;


import com.quiz_service.quiz_service.model.Quiz_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Quiz_repo extends JpaRepository<Quiz_model, Integer> {
}
