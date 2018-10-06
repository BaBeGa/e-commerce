package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ShopUpdateResponse {
    private ShopUpdateResponseBody result;

    @JsonGetter
    public ShopUpdateResponseBody getResult() {
        return result;
    }

    @JsonSetter
    public void setResult(ShopUpdateResponseBody result) {
        this.result = result;
    }
}
