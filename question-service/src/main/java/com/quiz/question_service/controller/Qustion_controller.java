package com.quiz.question_service.controller;


import com.quiz.question_service.Response.QuizSubmit_response;
import com.quiz.question_service.model.Question_model;
import com.quiz.question_service.model.Question_wrapper;
import com.quiz.question_service.service.Question_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
        @RequestMapping("/question")
public class Qustion_controller {


    @Autowired
    Question_service question_service;

    @GetMapping("/allquestion")
    public ResponseEntity<List<Question_model>> getquestion() {
        List<Question_model> questions = question_service.getallquestions();

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Question_model> addquestion(@RequestBody Question_model question_model) {
        Question_model question_model1 = question_service.addquestion(question_model);
        return new ResponseEntity<>(question_model1, HttpStatus.OK);

    }

    @GetMapping("/category/{topic}")
    public ResponseEntity<List<Question_model>> getquestion(@PathVariable String topic) {
        List<Question_model> questions = question_service.getsubjectquestions(topic);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    // both quiz and question service are working independently
    // so quiz service have no access to question db
    // question service have access to question db
    // quiz service request question from question service from https

    //request methods==>
    // genarate
    //getquestion(questionid)
    // getscore

    @GetMapping("/genarate")
    public ResponseEntity<List<Integer>> getquestionForquiz
            (@RequestParam int numq, @RequestParam String category) {
        List<Integer> questions = question_service.genaratequestion(numq, category);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @PostMapping("/getquestion")
    public ResponseEntity<List<Question_wrapper>> getquestionbyid(@RequestBody List<Integer> questionid) {
        return question_service.getquestionbyid(questionid);
    }

    @PostMapping("/getscore/{quizId}")
    public ResponseEntity<Integer> getscore(@PathVariable int quizId, @RequestBody List<QuizSubmit_response> answers) {
        int score = question_service.calculateScore(quizId, answers);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }



}
