package com.Quizapp.quiz.service;

import com.Quizapp.quiz.Response.QuizSubmit_response;
import com.Quizapp.quiz.model.Question_model;
import com.Quizapp.quiz.model.Question_wrapper;
import com.Quizapp.quiz.model.Quiz_model;
import com.Quizapp.quiz.repository.Question_repo;
import com.Quizapp.quiz.repository.Quiz_repo;
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
    Question_repo question_repo;
    @Autowired
    Quiz_repo quiz_repo;


    public void createquiz(String category, int numq, String title) {
        List<Question_model> questions = question_repo.findRandomQuestionsbycategory(category, numq);

        Quiz_model quiz = new Quiz_model();
        quiz.setQuiztitle(title);
        quiz.setQuestions(questions);
        quiz_repo.save(quiz);


    }

    public ResponseEntity<List<Question_wrapper>> getCreatedQuiz(int quizId) {

        Optional<Quiz_model> quiz = quiz_repo.findById(quizId);
        List<Question_model> question_wrappers = quiz.get().getQuestions();
        List<Question_wrapper> question_foruser =new ArrayList<>();
        for(Question_model question_model:question_wrappers){
            Question_wrapper question_wrapper=new Question_wrapper();
            question_wrapper.setId(question_model.getId());
            question_wrapper.setQuestiontitle(question_model.getQuestiontitle());
            question_wrapper.setOption1(question_model.getOption1());
            question_wrapper.setOption2(question_model.getOption2());
            question_wrapper.setOption3(question_model.getOption3());
            question_wrapper.setOption4(question_model.getOption4());
            question_foruser.add(question_wrapper);
        }
        return new ResponseEntity<>(question_foruser, HttpStatus.OK);
    }

    public int calculateScore(int quizId, List<QuizSubmit_response> answers) {
        Quiz_model quiz = quiz_repo.findById(quizId).get();
        List<Question_model> questions = quiz.getQuestions();
        int score = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).getAnswer().equals(questions.get(i).getRightanswer())) {
                score += 1;
            }
        }
        return score;
    }
}
