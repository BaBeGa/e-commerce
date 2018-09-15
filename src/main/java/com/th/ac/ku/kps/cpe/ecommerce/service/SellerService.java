package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.ShopCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.ShopCreateResponse;
import org.springframework.stereotype.Service;

@Service
public interface SellerService {
    ShopCreateResponse shopCreateResponse(ShopCreateRequest restRequest);
}
