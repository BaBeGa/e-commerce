package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.validation.constraints.NotNull;

public class ShopUpdateRequestBody {
    @NotNull
    private String name_shop;

    @JsonGetter
    public String getName_shop() {
        return name_shop;
    }

    @JsonSetter
    public void setName_shop(String name_shop) {
        this.name_shop = name_shop;
    }
}
