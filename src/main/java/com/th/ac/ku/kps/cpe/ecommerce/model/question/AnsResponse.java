package com.th.ac.ku.kps.cpe.ecommerce.model.question;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class AnsResponse {
    private String result;
    private Integer correct_choice;

    @JsonGetter
    public String getResult() {
        return result;
    }

    @JsonSetter
    public void setResult(String result) {
        this.result = result;
    }

    @JsonGetter
    public Integer getCorrect_choice() {
        return correct_choice;
    }

    @JsonSetter
    public void setCorrect_choice(Integer correct_choice) {
        this.correct_choice = correct_choice;
    }
}
