package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ShopCreateResponse {
    private ShopCreateResponseBody result;

    @JsonGetter
    public ShopCreateResponseBody getResult() {
        return result;
    }

    @JsonSetter
    public void setResult(ShopCreateResponseBody result) {
        this.result = result;
    }
}
