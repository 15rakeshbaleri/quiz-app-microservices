package com.Quizapp.quiz.controller;

import com.Quizapp.quiz.Response.QuizSubmit_response;
import com.Quizapp.quiz.model.Question_wrapper;
import com.Quizapp.quiz.service.Quiz_service;
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
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numq,
                                             @RequestParam String title) {
        try {
            quiz_service.createquiz(category, numq, title);  // assuming this method in your service class
            return new ResponseEntity<>("Quiz created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating quiz: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
