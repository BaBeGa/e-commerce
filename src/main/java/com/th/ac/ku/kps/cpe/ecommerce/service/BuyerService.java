package com.th.ac.ku.kps.cpe.ecommerce.service;

import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.create.OrderCreateResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.delete.OrderDeleteResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.read.OrderReadResponse;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateRequest;
import com.th.ac.ku.kps.cpe.ecommerce.model.buyer.order.update.OrderUpdateResponse;
import org.springframework.stereotype.Service;

@Service
public interface BuyerService {
    OrderReadResponse orderReadAllResponse(String token);
    OrderReadResponse orderReadResponse(String token, int id);
    OrderCreateResponse orderCreateResponse(String token, OrderCreateRequest restRequest);
    OrderUpdateResponse orderUpdateResponse(String token, OrderUpdateRequest restRequest);
    OrderDeleteResponse orderDeleteResponse(String token, OrderDeleteRequest restRequest);
}