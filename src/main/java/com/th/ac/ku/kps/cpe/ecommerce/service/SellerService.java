package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read.ProductReadAllResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.ShopCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.ShopCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.ShopUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.ShopUpdateResponse;
import org.springframework.stereotype.Service;

@Service
public interface SellerService {
    ShopCreateResponse shopCreateResponse(ShopCreateRequest restRequest);
    ShopUpdateResponse shopUpdateResponse(ShopUpdateRequest restRequest);
    ProductCreateResponse productCreateResponse(ProductCreateRequest restRequest);
    // Start Implement
    ProductReadAllResponse productReadAllResponse(String token);
}
