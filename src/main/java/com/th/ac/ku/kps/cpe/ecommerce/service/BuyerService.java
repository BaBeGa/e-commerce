package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.create.FavoriteProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.create.FavoriteProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.delete.FavoriteProductDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.delete.FavoriteProductDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.favoriteproduct.read.FavoriteProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.OrderReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderhistory.OrderHistoryReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderitem.OrderItemUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.orderitem.OrderItemUpdateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.create.RatingProductCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.create.RatingProductCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingproduct.read.RatingProductReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingshop.create.RatingShopCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.ratingshop.read.RatingShopReadResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BuyerService {
    ResponseEntity<?> orderReadAllResponse(String token);
    ResponseEntity<?> orderReadResponse(String token, int id);
    ResponseEntity<?> orderCreateResponse(String token, OrderCreateRequest restRequest);
    ResponseEntity<?> orderUpdateResponse(String token, OrderUpdateRequest restRequest);
    ResponseEntity<?> orderDeleteResponse(String token, Integer id_item);

    ResponseEntity<?> orderItemUpdateResponse(String token, OrderItemUpdateRequest restRequest);

    ResponseEntity<?> orderHistoryReadAllResponse(String token);
    ResponseEntity<?> orderHistoryReadResponse(String token, int id_order_history);

    ResponseEntity<?> ratingProductReadByIdOrderHistory(String token, int id);
    ResponseEntity<?> ratingProductCreate(String token, RatingProductCreateRequest restRequest);

    ResponseEntity<?> favoriteProductRead(String token);
    ResponseEntity<?> favoriteProductCreate(String token, FavoriteProductCreateRequest restRequest);
    ResponseEntity<?> favoriteProductDelete(String token, Integer id_product);

    ResponseEntity<?> ratingShopReadByIdOrderHistory(String token, int id);
    ResponseEntity<?> ratingShopCreate(String token, RatingShopCreateRequest restRequest);
}