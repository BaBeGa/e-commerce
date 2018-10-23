package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ShipOfShopCreateRequest {
    private ShipOfShopCreateBodyRequest body;
@JsonGetter
    public ShipOfShopCreateBodyRequest getBody() {
        return body;
    }
@JsonSetter
    public void setBody(ShipOfShopCreateBodyRequest body) {
        this.body = body;
    }
}
