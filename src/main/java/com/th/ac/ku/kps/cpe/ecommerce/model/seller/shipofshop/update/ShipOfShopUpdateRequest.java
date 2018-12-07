package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class ShipOfShopUpdateRequest {
    private ShipOfShopUpdateBodyRequest body;

    @JsonGetter
    public ShipOfShopUpdateBodyRequest getBody() {
        return body;
    }

    @JsonSetter
    public void setBody(ShipOfShopUpdateBodyRequest body) {
        this.body = body;
    }
}
