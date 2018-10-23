package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ShipOfShopDeleteRequest {
    private ShipOfShopDeleteBodyRequest body;
@JsonGetter
    public ShipOfShopDeleteBodyRequest getBody() {
        return body;
    }
@JsonSetter
    public void setBody(ShipOfShopDeleteBodyRequest body) {
        this.body = body;
    }
}
