package com.Quizapp.quiz.service;

import com.Quizapp.quiz.model.Question_model;
import com.Quizapp.quiz.repository.Question_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Question_service {
    @Autowired
    Question_repo question_repo;


    public List<Question_model> getallquestions() {
        List<Question_model> questions=   question_repo.findAll();

return questions;
    }

    public Question_model addquestion(Question_model questionModel) {

        Question_model question_model = question_repo.save(questionModel);
    return question_model;
    }

    public List<Question_model> getsubjectquestions(String topic) {
        List<Question_model> questions=   question_repo.findByCategory(topic);
        return questions;
    }
}
