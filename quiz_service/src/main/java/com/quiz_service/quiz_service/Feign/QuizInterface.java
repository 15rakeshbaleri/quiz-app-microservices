package com.quiz_service.quiz_service.Feign;

import com.quiz_service.quiz_service.Response.QuizSubmit_response;
import com.quiz_service.quiz_service.model.Question_wrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("question/genarate")
    public ResponseEntity<List<Integer>> getquestionForquiz
            (@RequestParam int numq, @RequestParam String category);

    @PostMapping("question/getquestion")
    public ResponseEntity<List<Question_wrapper>> getquestionbyid(@RequestBody List<Integer> questionid) ;

    @PostMapping("question/getscore/{quizId}")
    public ResponseEntity<Integer> getscore(@PathVariable int quizId, @RequestBody List<QuizSubmit_response> answers) ;
}
