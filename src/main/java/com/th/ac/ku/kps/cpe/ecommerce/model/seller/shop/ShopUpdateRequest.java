package com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.common.Header;

public class ShopUpdateRequest {
    private Header header;
    private ShopUpdateRequestBody request;

    @JsonGetter
    public Header getHeader() {
        return header;
    }

    @JsonSetter
    public void setHeader(Header header) {
        this.header = header;
    }

    @JsonGetter
    public ShopUpdateRequestBody getRequest() {
        return request;
    }

    @JsonSetter
    public void setRequest(ShopUpdateRequestBody request) {
        this.request = request;
    }
}
