package com.quiz_service.quiz_service.controller;

import lombok.Data;

@Data
public class Quizdto {
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumq() {
        return numq;
    }

    public void setNumq(int numq) {
        this.numq = numq;
    }

    private int numq;
    private String title;
}
