package com.Quizapp.quiz.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String quiztitle;

    public List<Question_model> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question_model> questions) {
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuiztitle() {
        return quiztitle;
    }

    public void setQuiztitle(String quiztitle) {
        this.quiztitle = quiztitle;
    }

    @ManyToMany
    private List<Question_model> questions;
}
