package com.quiz_service.quiz_service.model;

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

    @ElementCollection
    private List<Integer> questionids;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getQuestionids() {
        return questionids;
    }

    public void setQuestionids(List<Integer> questionids) {
        this.questionids = questionids;
    }

    public String getQuiztitle() {
        return quiztitle;
    }

    public void setQuiztitle(String quiztitle) {
        this.quiztitle = quiztitle;
    }
}
