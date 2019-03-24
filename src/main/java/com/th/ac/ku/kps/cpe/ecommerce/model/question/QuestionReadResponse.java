package com.th.ac.ku.kps.cpe.ecommerce.model.question;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class QuestionReadResponse {
    private List<QuestionBodyReadResponse> question;

    @JsonGetter
    public List<QuestionBodyReadResponse> getQuestion() {
        return question;
    }

    @JsonSetter
    public void setQuestion(List<QuestionBodyReadResponse> question) {
        this.question = question;
    }
}
