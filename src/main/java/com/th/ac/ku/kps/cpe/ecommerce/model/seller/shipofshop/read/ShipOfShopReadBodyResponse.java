package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

public class ShipOfShopReadBodyResponse {

    private List<ShipOfShopReadDataBodyResponse> ship_of_shop;
    @JsonGetter
    public List<ShipOfShopReadDataBodyResponse> getShip_of_shop() {
        return ship_of_shop;
    }
    @JsonSetter
    public void setShip_of_shop(List<ShipOfShopReadDataBodyResponse> ship_of_shop) {
        this.ship_of_shop = ship_of_shop;
    }
}
