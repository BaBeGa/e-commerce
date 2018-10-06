package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ShopUpdateResponseBody {
    private int result_code;
    private String result_description;

    @JsonGetter
    public int getResult_code() {
        return result_code;
    }
    @JsonSetter
    public void setResult_code(int result_code) {
        this.result_code = result_code;
    }
    @JsonGetter
    public String getResult_description() {
        return result_description;
    }
    @JsonSetter
    public void setResult_description(String result_description) {
        this.result_description = result_description;
    }
}
