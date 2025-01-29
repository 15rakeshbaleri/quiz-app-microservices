package com.quiz_service.quiz_service.service;

import com.quiz_service.quiz_service.Feign.QuizInterface;
import com.quiz_service.quiz_service.Response.QuizSubmit_response;
import com.quiz_service.quiz_service.model.Question_wrapper;
import com.quiz_service.quiz_service.model.Quiz_model;
import com.quiz_service.quiz_service.repository.Quiz_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Quiz_service {

@Autowired
QuizInterface quizInterface;

    @Autowired
    Quiz_repo quiz_repo;


    public String createquiz(String category, int numq, String title) {
        List<Integer> questions = quizInterface.getquestionForquiz(numq, category).getBody();

        Quiz_model quiz = new Quiz_model();
        quiz.setQuestionids(questions);
        quiz.setQuiztitle(title);
        quiz_repo.save(quiz);
        return null;
    }

    public ResponseEntity<List<Question_wrapper>> getCreatedQuiz(int quizId) {

   Quiz_model quiz = quiz_repo.findById(quizId).get();

        List<Integer> questionids = quiz.getQuestionids();
        quizInterface.getquestionbyid(questionids);
        ResponseEntity<List<Question_wrapper>> responseEntity = quizInterface.getquestionbyid(questionids);
        return responseEntity;

    }

    public int calculateScore(int quizId, List<QuizSubmit_response> answers) {

        return quizInterface.getscore(quizId, answers).getBody();
    }
}
