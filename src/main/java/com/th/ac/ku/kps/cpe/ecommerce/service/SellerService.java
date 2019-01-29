package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.read.OrderForSellerReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.update.OrderSellerUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.orderseller.update.OrderSellerUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.create.ProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.delete.ProductDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.read.ProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.product.update.ProductUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.create.PromotionCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.create.PromotionCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.delete.PromotionDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.delete.PromotionDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.read.PromotionReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.update.PromotionUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.promotion.update.PromotionUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.read.ShipOfShopReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.create.ShipOfShopCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.create.ShipOfShopCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.delete.ShipOfShopDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.delete.ShipOfShopDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.update.ShipOfShopUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.shipofshop.update.ShipOfShopUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.seller.statistics.StatisticsResponse;
import org.springframework.stereotype.Service;

@Service
public interface SellerService {

    ProductCreateResponse productCreateResponse(String token, ProductCreateRequest restRequest);
    ProductReadResponse productReadAllResponse(String token);
    ProductReadResponse productReadResponse(String token,int id);
    ProductUpdateResponse productUpdateResponse(String token, ProductUpdateRequest restRequest);
    ProductDeleteResponse productDeleteResponse(String token, ProductDeleteRequest restRequest);

    ShipOfShopReadResponse shipofshopReadResponse(String token);
    ShipOfShopCreateResponse shipofshopCreateResponse(String token, ShipOfShopCreateRequest restRequest);
    ShipOfShopUpdateResponse shipofshopUpdateResponse(String token, ShipOfShopUpdateRequest restRequest);
    ShipOfShopDeleteResponse shipofshopDeleteResponse(String token, ShipOfShopDeleteRequest restRequest);

    OrderForSellerReadResponse readAllOrderForSellerResponse(String token);
    OrderForSellerReadResponse readOrderForSellerResponse(String token, int id_item);
    OrderSellerUpdateResponse updateOrderForSellerResponse(String token, OrderSellerUpdateRequest restRequest);

    PromotionReadResponse readPromotion(String token);
    PromotionCreateResponse createPromotion(String token, PromotionCreateRequest restRequest);
    PromotionUpdateResponse updatePromotion(String token, PromotionUpdateRequest restRequest);
    PromotionDeleteResponse deletePromotion(String token, PromotionDeleteRequest restRequest);

    StatisticsResponse readStatistics(String token, Integer day_1, Integer month_1, Integer year_1, Integer day_2, Integer month_2, Integer year_2);
}
