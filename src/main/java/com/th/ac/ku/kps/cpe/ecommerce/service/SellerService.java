package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read.ProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.read.ShipOfShopReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.create.ShipOfShopCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.create.ShipOfShopCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.delete.ShipOfShopDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.delete.ShipOfShopDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.update.ShipOfShopUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.update.ShipOfShopUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.ShopCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.ShopCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.ShopUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shop.ShopUpdateResponse;
import org.springframework.stereotype.Service;

@Service
public interface SellerService {
    ShopCreateResponse shopCreateResponse(ShopCreateRequest restRequest);
    ShopUpdateResponse shopUpdateResponse(ShopUpdateRequest restRequest);
    // Start Implement
    ProductCreateResponse productCreateResponse(String token, ProductCreateRequest restRequest);
    ProductReadResponse productReadAllResponse(String token);
    ProductReadResponse productReadResponse(String token,int id);
    ProductUpdateResponse productUpdateResponse(String token, ProductUpdateRequest restRequest);
    ProductDeleteResponse productDeleteResponse(String token, ProductDeleteRequest restRequest);

    ShipOfShopReadResponse shipofshopReadResponse(String token);
    ShipOfShopCreateResponse shipofshopCreateResponse(String token, ShipOfShopCreateRequest restRequest);
    ShipOfShopUpdateResponse shipofshopUpdateResponse(String token, ShipOfShopUpdateRequest restRequest);
    ShipOfShopDeleteResponse shipofshopDeleteResponse(String token, ShipOfShopDeleteRequest restRequest);

}
