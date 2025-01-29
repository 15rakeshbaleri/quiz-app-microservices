package com.quiz.question_service.service;


import com.quiz.question_service.Response.QuizSubmit_response;
import com.quiz.question_service.model.Question_model;
import com.quiz.question_service.model.Question_wrapper;
import com.quiz.question_service.repository.Question_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Integer>  genaratequestion(int numq, String category) {
        List<Integer> questions = question_repo.findRandomQuestionsbycategory(category, numq);
    return questions;
    }

    public ResponseEntity<List<Question_wrapper>> getquestionbyid(List<Integer> questionid) {

        List<Question_wrapper> questionswrapper = new ArrayList<>();

        for (Integer i : questionid) {
            Question_wrapper question_wrapper = new Question_wrapper();
            Question_model question_model = question_repo.findById(i).get();
            question_wrapper.setId(question_model.getId());
            question_wrapper.setQuestiontitle(question_model.getQuestiontitle());
            question_wrapper.setOption1(question_model.getOption1());
            question_wrapper.setOption2(question_model.getOption2());
            question_wrapper.setOption3(question_model.getOption3());
            question_wrapper.setOption4(question_model.getOption4());
            questionswrapper.add(question_wrapper);


        }
        return new ResponseEntity<>(questionswrapper, HttpStatus.OK);
    }
    public int calculateScore(int quizId, List<QuizSubmit_response> answers) {


    int score = 0;
      for(QuizSubmit_response answer : answers) {
          Question_model question_model = question_repo.findById(answer.getId()).get();
          if (question_model.getRightanswer().equals(answer.getAnswer())) {
              score = score + 1;
          }

      }
        return score;
    }
}
