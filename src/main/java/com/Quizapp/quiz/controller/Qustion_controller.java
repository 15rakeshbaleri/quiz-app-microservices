package com.Quizapp.quiz.controller;

import com.Quizapp.quiz.model.Question_model;
import com.Quizapp.quiz.service.Question_service;
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
    public ResponseEntity<Question_model > addquestion(@RequestBody Question_model question_model) {
       Question_model question_model1 = question_service.addquestion(question_model);
        return new ResponseEntity<>(question_model1,HttpStatus.OK);

    }

    @GetMapping("/category/{topic}")
    public ResponseEntity<List<Question_model>> getquestion(@PathVariable String topic) {
        List<Question_model> questions = question_service.getsubjectquestions(topic);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
