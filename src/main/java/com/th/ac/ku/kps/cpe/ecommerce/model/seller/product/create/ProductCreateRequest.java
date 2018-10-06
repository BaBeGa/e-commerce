package com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.th.ac.ku.kps.cpe.ecommerce.common.Header;

public class ProductCreateRequest {
    private Header header;
    private ProductCreateBodyRequest body;

    @JsonGetter
    public Header getHeader() {
        return header;
    }
    @JsonSetter
    public void setHeader(Header header) {
        this.header = header;
    }
    @JsonGetter
    public ProductCreateBodyRequest getBody() {
        return body;
    }
    @JsonSetter
    public void setBody(ProductCreateBodyRequest body) {
        this.body = body;
    }
}
