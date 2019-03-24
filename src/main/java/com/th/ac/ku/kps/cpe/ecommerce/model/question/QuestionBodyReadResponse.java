package com.th.ac.ku.kps.cpe.ecommerce.model.question;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class QuestionBodyReadResponse {
    private Integer id;
    private String question;
    private String[] choice;

    @JsonGetter
    public Integer getId() {
        return id;
    }

    @JsonSetter
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter
    public String getQuestion() {
        return question;
    }

    @JsonSetter
    public void setQuestion(String question) {
        this.question = question;
    }

    @JsonGetter
    public String[] getChoice() {
        return choice;
    }

    @JsonSetter
    public void setChoice(String[] choice) {
        this.choice = choice;
    }
}
