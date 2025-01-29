package com.quiz_service.quiz_service.controller;


import com.quiz_service.quiz_service.Response.QuizSubmit_response;
import com.quiz_service.quiz_service.model.Question_wrapper;
import com.quiz_service.quiz_service.service.Quiz_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class Quiz_controller {

    @Autowired
    private Quiz_service quiz_service;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody Quizdto quizdto) {
      return new ResponseEntity<>(quiz_service.createquiz(quizdto.getCategory(),quizdto.getNumq(),quizdto.getTitle()),HttpStatus.CREATED);
    }


    @GetMapping("get/{quizId}")
    public ResponseEntity<List<Question_wrapper>> getQuiz(@PathVariable int quizId) {

        return  quiz_service.getCreatedQuiz(quizId);
    }

    @PostMapping("/submit/{quizId}")
    public ResponseEntity<String> submitQuiz(@PathVariable int quizId, @RequestBody List<QuizSubmit_response> answers) {

       int score = quiz_service.calculateScore(quizId,answers);

        return new ResponseEntity<>("Quiz score"+"  "+score, HttpStatus.CREATED);

    }
}
