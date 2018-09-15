package com.th.ac.ku.kps.cpe.ecommerce.model.seller;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.common.Header;

public class ShopCreateRequest {
    private Header header;
    private ShopCreateRequestBody request;

    @JsonGetter
    public Header getHeader() {
        return header;
    }

    @JsonSetter
    public void setHeader(Header header) {
        this.header = header;
    }

    @JsonGetter
    public ShopCreateRequestBody getRequest() {
        return request;
    }

    @JsonSetter
    public void setRequest(ShopCreateRequestBody request) {
        this.request = request;
    }
}
