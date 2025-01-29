package com.quiz.question_service.Response;

import lombok.Data;

@Data
public class QuizSubmit_response {
    private int id;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String answer;
}
